class TextEditor {
    private StringBuilder left;
    private StringBuilder right;

    public TextEditor() {
        left = new StringBuilder();
        right = new StringBuilder();
    }
    
    public void addText(String text) {
        left.append(text);
    }
    
    public int deleteText(int k) {
        int n = Math.min(k, left.length());
        left.setLength(left.length() - n);
        return n;
    }
    
    public String cursorLeft(int k) {
        int n = Math.min(k, left.length());
        String sub = left.substring(left.length() - n);
        left.setLength(left.length() - n);
        right.append(new StringBuilder(sub).reverse());
        return getLeftText();
    }
    
    public String cursorRight(int k) {
        int n = Math.min(k, right.length());
        String sub = right.substring(right.length() - n);
        right.setLength(right.length() - n);
        left.append(new StringBuilder(sub).reverse());
        return getLeftText();
    }
    
    private String getLeftText() {
        int start = Math.max(0, left.length() - 10);
        return left.substring(start, left.length());
    }
}