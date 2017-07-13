package ro.codewars.morsecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MorseCodeDecoder {

	public static class Cluster implements Comparable<Cluster>, Iterable<Integer> {
		private double centroid;
		private List<Integer> cluster;

		public Cluster() {
			centroid = Double.MAX_VALUE;
			cluster = new ArrayList<>();
		}

		public double getCentroid() {
			return centroid;
		}

		public void setCentroid(double centroid) {
			this.centroid = centroid;
		}

		public List<Integer> getCluster() {
			return cluster;
		}

		public void setCluster(List<Integer> cluster) {
			this.cluster = cluster;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Cluster o) {
			return Double.compare(centroid, o.getCentroid());
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Iterable#iterator()
		 */
		@Override
		public Iterator<Integer> iterator() {
			return new Iterator<Integer>() {
				private int iCrs = 0;

				/*
				 * (non-Javadoc)
				 * 
				 * @see java.util.Iterator#hasNext()
				 */
				@Override
				public boolean hasNext() {
					return iCrs < cluster.size();
				}

				/*
				 * (non-Javadoc)
				 * 
				 * @see java.util.Iterator#next()
				 */
				@Override
				public Integer next() {
					return cluster.get(iCrs++);
				}

			};
		}

	}

	public static class KMean implements Iterable<Cluster> {

		private Cluster[] clusters;

		public KMean(int noClusters) {
			clusters = new Cluster[noClusters];
			for (int i = 0; i < noClusters; i++) {
				clusters[i] = new Cluster();
			}
		}

		public int getNoClusters() {
			return clusters.length;
		}

		public Cluster getCluster(int index) {
			return clusters[index];
		}

		public int getTotalNoClusters() {
			return Arrays.asList(clusters).stream().map(c -> c.getCluster().size()).reduce(0, (r, e) -> r + e);
		}

		public void sortClusters() {
			Arrays.sort(clusters, new Comparator<Cluster>() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see java.util.Comparator#compare(java.lang.Object,
				 * java.lang.Object)
				 */
				@Override
				public int compare(Cluster o1, Cluster o2) {
					return o1.compareTo(o2);
				}
			});
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Iterable#iterator()
		 */
		@Override
		public Iterator<Cluster> iterator() {
			return new Iterator<MorseCodeDecoder.Cluster>() {

				private int iCrs = 0;

				/*
				 * (non-Javadoc)
				 * 
				 * @see java.util.Iterator#hasNext()
				 */
				@Override
				public boolean hasNext() {
					return iCrs < clusters.length;
				}

				/*
				 * (non-Javadoc)
				 * 
				 * @see java.util.Iterator#next()
				 */
				@Override
				public Cluster next() {
					return clusters[iCrs++];
				}
			};
		}

	}

	public static String trimBy0(String text) {

		if (text == null) {
			return "";
		}

		int beginIndex = 0;
		int endIndex = text.length();

		boolean beginIndexFound = false;
		boolean endIndexFound = false;

		int iCrs = 0;

		while (beginIndex < endIndex && (beginIndexFound == false || endIndexFound == false)) {
			char chBegin = text.charAt(iCrs);
			char chEnd = text.charAt(text.length() - 1 - iCrs);

			if (chBegin == '0' && beginIndexFound == false) {
				beginIndex++;
			} else {
				beginIndexFound = true;
			}

			if (chEnd == '0' && endIndexFound == false) {
				endIndex--;
			} else {
				endIndexFound = true;
			}

			iCrs++;
		}

		return (beginIndexFound == true && endIndexFound == true) ? text.substring(beginIndex, endIndex) : "";
	}

	public static List<Integer> buildObservations(String bits) {
		// Initialize the result
		List<Integer> observations = new ArrayList<>();

		int currentObservation = 0;
		char currentBit = '1';

		for (int i = 0; i < bits.length(); i++) {
			if (currentBit == bits.charAt(i)) {
				currentObservation++;
			} else {
				observations.add(currentObservation);
				currentBit = bits.charAt(i);
				currentObservation = 1;
			}
		}

		observations.add(currentObservation);

		return observations;
	}

	public static void clustering(List<Integer> x, KMean kmean) {
		for (int index = 0; index < x.size(); index++) {
			double minValue = Double.MAX_VALUE;
			Cluster minCluster = null;

			for (Cluster cluster : kmean) {
				double distance = Math.pow(Math.abs(cluster.getCentroid() - x.get(index)), 2);
				if (distance < minValue) {
					minValue = distance;
					minCluster = cluster;
				}
			}

			if (minCluster != null) {
				minCluster.getCluster().add(index);
			} else {
				throw new RuntimeException("NO cluster found.");
			}
		}
	}

	public static double computeCentroid(List<Integer> cluster, List<Integer> x) {
		return ((double) cluster.stream().reduce(0, (r, e) -> r + x.get(e))) / cluster.size();
	}

	public static KMean kmeans(int noClusters, List<Integer> x) {
		KMean kmean = new KMean(noClusters);

		if (x.size() > 0) {
			// Initialize clusters.
			int minX = Collections.min(x);
			int maxX = Collections.max(x);
			//double step = (((double) maxX) - minX) / ((double) noClusters);
			double centroid = minX;
			
			double mean = 
					(double) (x.stream().distinct().reduce(0, (r, e) -> r + e)) / x.stream().distinct().count();
			
			if (mean < 2) {
				kmean.getCluster(0).setCentroid(minX);
				kmean.getCluster(1).setCentroid(Double.MAX_VALUE);
				kmean.getCluster(2).setCentroid(Double.MAX_VALUE);
			} else if (mean < 3) {
				kmean.getCluster(0).setCentroid(minX);
				kmean.getCluster(1).setCentroid(maxX);
				kmean.getCluster(2).setCentroid(Double.MAX_VALUE);
			} else {
				kmean.getCluster(0).setCentroid(minX);
				kmean.getCluster(1).setCentroid((maxX + minX) / 2);
				kmean.getCluster(2).setCentroid(maxX);
			}

			
			// Clustering
			boolean bFound = false;
			do {
				// Cluster observations
				clustering(x, kmean);

				// Compute new centroids
				bFound = false;
				KMean newKMean = new KMean(noClusters);
				for (int iCrs = 0; iCrs < noClusters; iCrs++) {
					Cluster crtCluster = kmean.getCluster(iCrs);

					if (crtCluster.getCluster().size() > 0) {
						centroid = computeCentroid(crtCluster.getCluster(), x);
						newKMean.getCluster(iCrs).setCentroid(centroid);

						if (centroid != crtCluster.getCentroid()) {
							bFound = true;
						}
					} else {
						//newKMean.getCluster(iCrs).setCentroid(Double.MAX_VALUE);
					}
				}
				if (bFound == true) {
					kmean = newKMean;
				}
			} while (bFound == true);
		}

		/*
		for (Cluster cluster : kmean) {
			if (cluster.getCluster().size() == 0) {
				cluster.setCentroid(Double.MAX_VALUE);
			}
		}
		*/

		return kmean;
	}

	public static void fillCharsWithClusterIndex(char[] chMorse, char evenChar, char oddChar, KMean kmean,
			int kmeanIndex) {
		for (int index : kmean.getCluster(kmeanIndex)) {
			if (index % 2 == 0) {
				chMorse[index] = evenChar;
			} else {
				chMorse[index] = oddChar;
			}
		}
	}

	public static String buildMorseCode(List<Integer> observations) {

		KMean kmean = kmeans(3, observations);
		kmean.sortClusters();

		// Build morse string
		char[] chMorse = new char[kmean.getTotalNoClusters()];

		// Parse first cluster (. and "")
		fillCharsWithClusterIndex(chMorse, '.', '#', kmean, 0);

		// Parse first cluster (- and " ")
		fillCharsWithClusterIndex(chMorse, '-', ' ', kmean, 1);

		// Parse first cluster (- and " ")
		fillCharsWithClusterIndex(chMorse, '-', '$', kmean, 2);

		return new String(chMorse).replaceAll("#", "").replaceAll("\\$", "   ").trim();

	}

	/**
	 * Given a string in Morse Code, returns the English translation.
	 *
	 * Accept dots, dashes and spaces, returns human-readable message.
	 */
	public static String decodeMorse(String morseCode) {
		String morseDecode = "";

		if (morseCode.equals("") == false) {
			// Split in words
			String[] morseWords = morseCode.split("   ");

			for (String morseWord : morseWords) {
				// Split in letters
				String[] morseLetters = morseWord.split(" ");

				for (String morseLetter : morseLetters) {
					String letter = MorseCode.get(morseLetter);
					if (letter != null) {
						morseDecode += letter;
					}
				}

				morseDecode += " ";
			}
		}

		return morseDecode.trim();
	}

	/**
	 * Given a string of bits, which may or may not begin or end with '0's, and
	 * which may have some variation in the length of the time unit used,
	 * returns the Morse Code translation of this message.
	 *
	 * Accepts 0s and 1s, return dots, dashes and spaces
	 *
	 */
	public static String decodeBitsAdvanced(String bits) {

		String morseCode = "";

		// 110110100111000001100000011111101001111100111111000000000001110111111110111110111110000001011000111111000001111100111011000001
		bits = trimBy0(bits);

		if (bits.equals("") == false) {
			morseCode = buildMorseCode(buildObservations(bits));
		}

		return morseCode;
	}
}

/*
 * https://www.codewars.com/kata/decode-the-morse-code-for-real/train/java
 * 
 * 
 * .... . -.-- .--- ..- -.. .
 * 
 * 0000000011011010011100000110000001111110100111110011111100000000000111011111111011111011111000000101100011111100000111110011101100000100000
 * 
 * 00000000 11 . 0 11 . 0 1 . 00 111 . 00000 11 . 000000 111111 - 0 1 . 00 11111
 * - 00 111111 - 00000000000 111 . 0 11111111 - 0 11111 - 0 11111 - 000000 1 . 0
 * 11 . 000 111111 - 00000 11111 - 00 111 . 0 11 . 00000 1 . 00000
 * 
 * 
 * 0000000011011010011100000110000001111110100111110011111100000000000111011111111011111011111000000101100011111100000111110011101100000100000
 * 
 * 2 1 2 1 1 2 3 5 2 6 6 1 1 2 5 2 6 11 3 1 8 1 5 1 5 6 1 1 2 3 6 5 5 2 3 1 2 5
 * 1 1: 2 2 1 3 2 6 1 5 6 3 8 5 5 1 2 6 5 3 2 1 0: 1 1 2 5 6 1 2 2 11 1 1 1 6 1
 * 3 5 2 1 5 ./-: . . . . . - . - - . - - - . . - - . . .
 * 
 * 
 * 
 */
