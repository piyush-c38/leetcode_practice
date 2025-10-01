class Spreadsheet {
    private int[][] sheet;

    public Spreadsheet(int rows) {
        sheet = new int[rows][26];
    }

    private int[] parseCell(String cell) {
        char column = cell.charAt(0);
        int row = Integer.parseInt(cell.substring(1));
        int colIndex = column - 'A';
        int rowIndex = row - 1; // convert to 0-based
        return new int[]{rowIndex, colIndex};
    }

    public void setCell(String cell, int value) {
        int[] idx = parseCell(cell);
        sheet[idx[0]][idx[1]] = value;
    }

    public void resetCell(String cell) {
        int[] idx = parseCell(cell);
        sheet[idx[0]][idx[1]] = 0;
    }

    public int getValue(String formula) {
        // remove leading '='
        formula = formula.substring(1);

        String[] parts = formula.split("\\+");
        String left = parts[0].trim();
        String right = parts[1].trim();

        return evalTerm(left) + evalTerm(right);
    }

    private int evalTerm(String term) {
        if (Character.isLetter(term.charAt(0))) {
            int[] idx = parseCell(term);
            return sheet[idx[0]][idx[1]];
        } else {
            return Integer.parseInt(term);
        }
    }
}
