package me.siyoon;

public class Main {
    public static void main(String[] args) {
        Pawn pawn1 = new Pawn();
        Board.a1.setChessmen(pawn1);
        System.out.println("Board.a1.getChessmen().getCharValue() = " + Board.a1.getChessmen().getCharValue());

        final Board.Coordinate coordinate = Board.a1.getCoordinate();
        System.out.println("coordinate.getI() = " + coordinate.getI());
        System.out.println("coordinate.getJ() = " + coordinate.getJ());

        final Board a3 = Board.valueOf("a3");
        System.out.println("a3.getCoordinate().getI() + a3.getCoordinate().getJ() = " + a3.getCoordinate().getI() + ", " + a3.getCoordinate().getJ());

        final Board boardByIndex = Board.getBoardByIndex(0, 4);
        System.out.println("boardByIndex.getCoordinate().getI() +\", \" + boardByIndex.getCoordinate().getJ() = " + boardByIndex.getCoordinate().getI() + ", " + boardByIndex.getCoordinate().getJ());
    }
}
