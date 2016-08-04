package scalar;

public abstract class Epic<T> {

	    private T t;

	    private Epic(T t) {
	        this.t = t;
	    }

	    private static class Win<T> extends Epic<T> {

	        public Win(T t) {
	            super(t);
	        }

	        public boolean isWin() {
	            return true;
	        }

	        public boolean isFail() {
	            return false;
	        }

	        public String message() {
	            return "";
	        }
	    }

	    private static class Fail<T> extends Epic<T> {
	        private String message;

	        public Fail(T t, String message) {
	            super(t);
	            this.message = message;
	        }

	        public boolean isWin() {
	            return false;
	        }

	        public boolean isFail() {
	            return true;
	        }

	        public String message() {
	            return message;
	        }
	    }

	    public static <T> Epic<T> win(T t) {
	        return new Win(t);
	    }

	    public static <T> Epic<T> fail(T t, String message) {
	        return new Fail(t, message);
	    }

	    public T result() {
	        return t;
	    }

	    public abstract boolean isWin();

	    public abstract boolean isFail();

	    public abstract String message();
	
}
