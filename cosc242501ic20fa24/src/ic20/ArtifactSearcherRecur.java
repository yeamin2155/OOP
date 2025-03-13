package ic20;

public class ArtifactSearcherRecur {
    private String[] artifacts;

    public ArtifactSearcherRecur(String[] artifacts) {
        this.artifacts = artifacts;
    }

    public int binarySearch(String target) {
        return binarySearchRecursive(target, 0, artifacts.length - 1, 1);
    }

    private int binarySearchRecursive(String target, int low, int high, int comparisons) {
        if (low > high) {
            System.out.println("Number of comparisons: " + comparisons);
            return -1;
        }

        int mid = (low + high) / 2;
        int comparisonResult = target.compareTo(artifacts[mid]);

        if (comparisonResult == 0) {
            System.out.println("Number of comparisons: " + comparisons);
            return mid;
        } else if (comparisonResult < 0) {
            return binarySearchRecursive(target, low, mid - 1, comparisons + 1);
        } else {
            return binarySearchRecursive(target, mid + 1, high, comparisons + 1);
        }
    }
}
