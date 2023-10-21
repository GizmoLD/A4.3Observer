public abstract class Observable<PR450Magatzem> {
    private PR450Magatzem value;

    public Observable(PR450Magatzem value) {
        this.value = value;
    }

    public PR450Magatzem getValue() {
        return value;
    }

    public void setValue(PR450Magatzem value) {
        PR450Magatzem oldValue = this.value;
        this.value = value;
        this.propertyChange(oldValue, value);
    }

    public abstract void propertyChange(PR450Magatzem oldValue, PR450Magatzem newValue);
}

/*
 * public abstract class Observable<PR450Magatzem> {
    private PR450Magatzem value;

    public Observable(PR450Magatzem value) {
        this.value = value;
    }

    public PR450Magatzem getValue() {
        return value;
    }

    public void setValue(PR450Magatzem value) {
        PR450Magatzem oldValue = this.value;
        this.value = value;
        this.propertyChange(oldValue, value);
    }

    public abstract void propertyChange(PR450Magatzem oldValue, PR450Magatzem newValue);
}
 */