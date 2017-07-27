import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ioana-chirca on 20-Jul-17.
 */
class Move {
    private int origin;
    private int destination;

    public Move() {}

    public Move(int origin, int destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public int getOrigin() {
        return origin;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public String toString() {
        return "Move from " + origin + " to " + destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Move move = (Move) o;

        if (origin != move.origin) return false;
        return destination == move.destination;
    }

    @Override
    public int hashCode() {
        int result = origin;
        result = 31 * result + destination;
        return result;
    }
}

public class RearrangingCars {
    public static ArrayList<Move> optimisedRearrange(int[] originalOrder, int[] finalOrder) {
        if (originalOrder == null || finalOrder == null || originalOrder.length != finalOrder.length)
            return null;

        // Idea: Repeatedly replace current empty spot with the car that has to go there

        ArrayList<Move> moves = new ArrayList<>();
        if (originalOrder.length == 0) return moves;

        HashMap<Integer, Integer> positions = new HashMap<>();
        int N = originalOrder.length;
        int[] originalOrderCopy = originalOrder.clone();
        for (int i = 0; i < N; i++) {
            positions.put(originalOrderCopy[i], i);
        }

        while (true) {
            int emptySlotPosition = positions.get(0);

            if (finalOrder[emptySlotPosition] != 0) {
                // move right car into empty slot
                int desiredCar = finalOrder[emptySlotPosition];
                int desiredCarPosition = positions.get(desiredCar);

                moves.add(new Move(desiredCarPosition, emptySlotPosition));

                originalOrderCopy[emptySlotPosition] = desiredCar;
                originalOrderCopy[desiredCarPosition] = 0;

                positions.put(desiredCar, emptySlotPosition);
                positions.put(0, desiredCarPosition);
            } else {
                // check if all the cars are in the right positions
                int carPosition;
                for (carPosition = 0; carPosition < N; carPosition++) {
                    if (originalOrderCopy[carPosition] != finalOrder[carPosition]) {
                        break;
                    }
                }
                if (carPosition == N) {
                    // finished rearranging
                    break;
                } else {
                    // the empty slot is where it needs to be, but other cars aren't
                    // we move the first wrong car into the empty slot
                    int wrongCar = originalOrderCopy[carPosition];

                    moves.add(new Move(carPosition, emptySlotPosition));

                    originalOrderCopy[emptySlotPosition] = wrongCar;
                    originalOrderCopy[carPosition] = 0;

                    positions.put(wrongCar, emptySlotPosition);
                    positions.put(0, carPosition);

                }
            }
        }

        return moves;
    }

    public static ArrayList<Move> rearrange(int[] originalOrder, int[] finalOrder) {
        if (originalOrder == null || finalOrder == null || originalOrder.length != finalOrder.length)
            return null;

        ArrayList<Move> moves = new ArrayList<>();
        if (originalOrder.length == 0) return moves;

        HashMap<Integer, Integer> positions = new HashMap<>();
        int N = originalOrder.length;
        int[] originalOrderCopy = originalOrder.clone();
        for (int i = 0; i < N; i++) {
            positions.put(originalOrderCopy[i], i);
        }

        int index = 0;
        while (index < N) {
            if (originalOrderCopy[index] == finalOrder[index]) {
                // nothing to modify, the cars already match
                index++;
            } else {
                // must bring the desired car in the index position
                // first we move the current car (if we have one) into the empty slot
                if (originalOrderCopy[index] != 0) {
                    moves.add(new Move(index, positions.get(0)));

                    int emptySlotPosition = positions.get(0);
                    int currentCar = originalOrderCopy[index];

                    originalOrderCopy[emptySlotPosition] = currentCar;
                    originalOrderCopy[index] = 0;
                    positions.put(currentCar, emptySlotPosition);
                    positions.put(0, index);
                }

                if (finalOrder[index] != 0) {
                    // we bring the desired car into the new empty slot
                    moves.add(new Move(positions.get(finalOrder[index]), index));

                    int emptySlotPosition = index;
                    int desiredCar = finalOrder[index];
                    int desiredCarPosition = positions.get(desiredCar);

                    originalOrderCopy[emptySlotPosition] = desiredCar;
                    originalOrderCopy[desiredCarPosition] = 0;
                    positions.put(desiredCar, emptySlotPosition);
                    positions.put(0, desiredCarPosition);
                }

                index++;
            }
        }

        return moves;
    }

    public static void main(String[] args) {
        int[] originalOrder = {1, 2, 0, 3};
        int[] finalOrder = {3, 1, 2, 0};

        System.out.println("Normal rearrange:");
        ArrayList<Move> moves1 = rearrange(originalOrder, finalOrder);
        for(Move move : moves1) {
            System.out.println(move);
        }

        System.out.println("Optimised rearrange:");
        ArrayList<Move> moves2 = optimisedRearrange(originalOrder, finalOrder);
        for(Move move : moves2) {
            System.out.println(move);
        }

    }
}
