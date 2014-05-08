import java.util.ArrayList;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * Created by nullzine on 2014/04/30.
 */
public class Main {
    public static void main(String[] args) {
        System.out.print(new QuadNQueen(4, 4).getExclusveStringList());
    }
}

class SixNQueen{

    private int row;
    private int column;
    private ArrayList<QueenField> queenFieldList;

    public SixNQueen(int row, int column) {
        this.row = row;
        this.column = column;
        queenFieldList = new ArrayList<>();
        //calculation();
        lambdaCalculation();
    }

    private void lambdaCalculation() {
        IntStream.range(1, row + 1).forEach(
                a -> IntStream.range(1, row + 1).filter(i -> a != i).forEach(
                        b -> IntStream.range(1, row + 1).filter(j -> a != j && b != j).forEach(
                                c -> IntStream.range(1, row + 1).filter(k -> a != k && b != k && c != k).forEach(
                                        d -> IntStream.range(1, column + 1).forEach(
                                                e -> IntStream.range(1, column + 1).filter(l -> e != l).forEach(
                                                        f -> IntStream.range(1, column + 1).filter(m -> e != m && f != m).forEach(
                                                                g -> IntStream.range(1, column + 1).filter(n -> e != n && f != n && g != n).forEach(
                                                                        h -> validField(new QueenField(new Queen(a, e), new Queen(b, f), new Queen(c, g), new Queen(d, h))))
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    private void calculation() {
        for (int a = 1; a <= row; a++) {
            for (int b = 1; b <= row; b++) {
                if (b != a) {
                    for (int c = 1; c <= row; c++) {
                        if (c != a && c != b) {
                            for (int d = 1; d <= row; d++) {
                                if (d != a && d != b && d != c) {
                                    for (int e = 1; e <= column; e++) {
                                        for (int f = 1; f <= column; f++) {
                                            if (f != e) {
                                                for (int g = 1; g <= column; g++) {
                                                    if (g != e && g != f) {
                                                        for (int h = 1; h <= column; h++) {
                                                            if (h != e && h != f && h != g) {
                                                                validField(new QueenField(new Queen(a, e), new Queen(b, f), new Queen(c, g), new Queen(d, h)));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void validField(QueenField qf) {
        if (qf.slantCheck()) {
            add(qf);
        }
    }

    synchronized void add(QueenField qf) {
        queenFieldList.add(qf);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queenFieldList.size(); i++) {
            sb.append(queenFieldList.get(i).toString(row, column) + "\n");
        }
        return sb.toString();
    }

    public String getExclusveStringList() {
        TreeSet<String> tmp = getExclusiveQueenFieldListString();
        StringBuilder sb = new StringBuilder();
        for (String s : tmp) {
            sb.append(s + "\n");
        }
        return sb.toString();
    }

    public int exclusiveSize() {
        return getExclusiveQueenFieldListString().size();
    }

    private TreeSet<String> getExclusiveQueenFieldListString() {
        TreeSet<String> tmp = new TreeSet<>();
        for (int i = 0; i < queenFieldList.size(); i++) {
            tmp.add(queenFieldList.get(i).toString(row, column));
        }
        return tmp;
    }

    public int size() {
        return queenFieldList.size();
    }

    class QueenField {

        private Queen a;
        private Queen b;
        private Queen c;
        private Queen d;

        public QueenField(Queen a, Queen b, Queen c, Queen d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        /*
        ab
        ac
        ad
        bc
        bd
        cd
         */

        public boolean slantCheck() {
            return Math.abs(a.getRow() - b.getRow()) != Math.abs(a.getColumn() - b.getColumn())
                    && Math.abs(a.getRow() - c.getRow()) != Math.abs(a.getColumn() - c.getColumn())
                    && Math.abs(a.getRow() - d.getRow()) != Math.abs(a.getColumn() - d.getColumn())
                    && Math.abs(b.getRow() - c.getRow()) != Math.abs(b.getColumn() - c.getColumn())
                    && Math.abs(b.getRow() - d.getRow()) != Math.abs(b.getColumn() - d.getColumn())
                    && Math.abs(c.getRow() - d.getRow()) != Math.abs(c.getColumn() - d.getColumn());
        }

        public String toString(int fieldRow, int fieldColumn) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= fieldRow; i++) {
                for (int j = 1; j <= fieldColumn; j++) {
                    if ((i == a.getRow() && j == a.getColumn()) || (i == b.getRow() && j == b.getColumn()) || (i == c.getRow() && j == c.getColumn()) || (i == d.getRow() && j == d.getColumn())) {
                        sb.append("#");
                    } else {
                        sb.append(".");
                    }
                }
                sb.append("\n");
            }
            return sb.toString();
        }

    }

    class Queen {

        private int row;
        private int column;

        public Queen(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

    }

}

class QuadNQueen {

    private int row;
    private int column;
    private ArrayList<QueenField> queenFieldList;

    public QuadNQueen(int row, int column) {
        this.row = row;
        this.column = column;
        queenFieldList = new ArrayList<>();
        //calculation();
        lambdaCalculation();
    }

    private void lambdaCalculation() {
        IntStream.range(1, row + 1).forEach(
                a -> IntStream.range(1, row + 1).filter(i -> a != i).forEach(
                        b -> IntStream.range(1, row + 1).filter(j -> a != j && b != j).forEach(
                                c -> IntStream.range(1, row + 1).filter(k -> a != k && b != k && c != k).forEach(
                                        d -> IntStream.range(1, column + 1).forEach(
                                                e -> IntStream.range(1, column + 1).filter(l -> e != l).forEach(
                                                        f -> IntStream.range(1, column + 1).filter(m -> e != m && f != m).forEach(
                                                                g -> IntStream.range(1, column + 1).filter(n -> e != n && f != n && g != n).forEach(
                                                                        h -> validField(new QueenField(new Queen(a, e), new Queen(b, f), new Queen(c, g), new Queen(d, h))))
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    private void calculation() {
        for (int a = 1; a <= row; a++) {
            for (int b = 1; b <= row; b++) {
                if (b != a) {
                    for (int c = 1; c <= row; c++) {
                        if (c != a && c != b) {
                            for (int d = 1; d <= row; d++) {
                                if (d != a && d != b && d != c) {
                                    for (int e = 1; e <= column; e++) {
                                        for (int f = 1; f <= column; f++) {
                                            if (f != e) {
                                                for (int g = 1; g <= column; g++) {
                                                    if (g != e && g != f) {
                                                        for (int h = 1; h <= column; h++) {
                                                            if (h != e && h != f && h != g) {
                                                                validField(new QueenField(new Queen(a, e), new Queen(b, f), new Queen(c, g), new Queen(d, h)));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void validField(QueenField qf) {
        if (qf.slantCheck()) {
            add(qf);
        }
    }

    synchronized void add(QueenField qf) {
        queenFieldList.add(qf);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queenFieldList.size(); i++) {
            sb.append(queenFieldList.get(i).toString(row, column) + "\n");
        }
        return sb.toString();
    }

    public String getExclusveStringList() {
        TreeSet<String> tmp = getExclusiveQueenFieldListString();
        StringBuilder sb = new StringBuilder();
        for (String s : tmp) {
            sb.append(s + "\n");
        }
        return sb.toString();
    }

    public int exclusiveSize() {
        return getExclusiveQueenFieldListString().size();
    }

    private TreeSet<String> getExclusiveQueenFieldListString() {
        TreeSet<String> tmp = new TreeSet<>();
        for (int i = 0; i < queenFieldList.size(); i++) {
            tmp.add(queenFieldList.get(i).toString(row, column));
        }
        return tmp;
    }

    public int size() {
        return queenFieldList.size();
    }

    class QueenField {

        private Queen a;
        private Queen b;
        private Queen c;
        private Queen d;

        public QueenField(Queen a, Queen b, Queen c, Queen d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        /*
        ab
        ac
        ad
        bc
        bd
        cd
         */

        public boolean slantCheck() {
            return Math.abs(a.getRow() - b.getRow()) != Math.abs(a.getColumn() - b.getColumn())
                    && Math.abs(a.getRow() - c.getRow()) != Math.abs(a.getColumn() - c.getColumn())
                    && Math.abs(a.getRow() - d.getRow()) != Math.abs(a.getColumn() - d.getColumn())
                    && Math.abs(b.getRow() - c.getRow()) != Math.abs(b.getColumn() - c.getColumn())
                    && Math.abs(b.getRow() - d.getRow()) != Math.abs(b.getColumn() - d.getColumn())
                    && Math.abs(c.getRow() - d.getRow()) != Math.abs(c.getColumn() - d.getColumn());
        }

        public String toString(int fieldRow, int fieldColumn) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= fieldRow; i++) {
                for (int j = 1; j <= fieldColumn; j++) {
                    if ((i == a.getRow() && j == a.getColumn()) || (i == b.getRow() && j == b.getColumn()) || (i == c.getRow() && j == c.getColumn()) || (i == d.getRow() && j == d.getColumn())) {
                        sb.append("#");
                    } else {
                        sb.append(".");
                    }
                }
                sb.append("\n");
            }
            return sb.toString();
        }

    }

    class Queen {

        private int row;
        private int column;

        public Queen(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

    }

}