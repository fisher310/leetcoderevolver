package util;

public class Partition<E> {

    private class Locator<E> implements Position<E> {

        E element;
        int size;
        Locator<E> parent;

        Locator(E elem) {
            this.element = elem;
            this.size = 1;
            this.parent = this;
        }

        @Override
        public E getElement() {
            return null;
        }

        private boolean validate(Partition<E> partition) {
            return Partition.this == partition;
        }
    }

    /**
     * make a new cluster containing element e and return its position
     *
     * @param e
     * @return
     */
    public Position<E> makeCluster(E e) {
        return new Locator<>(e);
    }

    /**
     * find the cluster containing the element identified by Position p and return the Position of
     * the cluster leader
     */
    public Position<E> find(Position<E> p) {
        Locator<E> loc = validate(p);
        if (loc.parent != loc) {
            loc.parent = (Locator<E>) find(loc.parent);
        }
        return loc.parent;
    }

    /**
     * merges the clusters contains elements with position p and q (if distinct)
     *
     * @param p
     * @param q
     */
    public void union(Position<E> p, Position<E> q) {
        Locator<E> a = (Locator<E>) find(p);
        Locator<E> b = (Locator<E>) find(q);
        if (a != b) {
            if (a.size > b.size) {
                b.parent = a.parent;
                a.size += b.size;
            } else {
                a.parent = b.parent;
                b.size += a.size;
            }
        }
    }

    private Locator<E> validate(Position<E> p) {
        if (!(p instanceof Locator)) throw new IllegalArgumentException("Invalid position");

        Locator<E> loc = (Locator<E>) p;
        if (!loc.validate(this)) {
            throw new IllegalArgumentException("Position does not belong to this structure");
        }
        return loc;
    }
}
