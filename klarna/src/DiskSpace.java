import java.util.Set;
import java.util.Arrays;
public class DiskSpace {

    public static boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors) {
        if (fileSize > blockSize) {
            return false;
        }

        if (occupiedSectors == null || occupiedSectors.isEmpty()) {
            return true;
        }

        Integer[] occupiedSects = occupiedSectors.toArray(new Integer[0]);
        Arrays.sort(occupiedSects);
        Integer firstOccupiedSector = occupiedSects[0];

        if ((firstOccupiedSector - 1) >= fileSize) {
            return true;
        }

        int length = occupiedSects.length;
        if (canFitBetweenTheSectors(fileSize, occupiedSects, length)){
            return true;
        }

        int lastOccupiedSector = occupiedSects[length - 1];
        return (blockSize - lastOccupiedSector) >= fileSize;
    }

    private static boolean canFitBetweenTheSectors(int fileSize, Integer[] occupiedSects, int length) {
        for (int index = 0; index < length - 1; index++) {
            int currentOccupiedSector = occupiedSects[index];
            int nextOccupiedSector = occupiedSects[index + 1];
            if ((nextOccupiedSector - currentOccupiedSector - 1) >= fileSize) {
                return true;
            }
        }
        return false;
    }
}