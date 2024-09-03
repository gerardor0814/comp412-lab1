public record Pair<T, U>(T t, U u) {

    @Override
    public String toString() {
        return "<" + t + ", " + u + ">";
    }

    public boolean isEOF() {
        return t == "ENDFILE";
    }
}
