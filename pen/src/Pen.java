/**
 * A pen that writes using a refill and uses a pluggable open/close mechanism.
 *
 * Strategy pattern — the open/close behaviour is injected, so Pen doesn't
 * need to know whether it's a cap pen, click pen, or anything else.
 * Refill is composed in and can be swapped at runtime.
 */
public class Pen{
    private final OpenCloseStrategy openCloseMechanism;
    private Refill refill;

    public Pen(OpenCloseStrategy openCloseMechanism, Refill refill) {
        this.openCloseMechanism = openCloseMechanism;
        this.refill = refill;
    }

    public void write(String text){
        if (refill.isEmpty()) {
            System.out.println("Refill is empty, can't write. Change refill first.");
            return;
        }
        openCloseMechanism.open();
        System.out.println("Writing '" + text + "' in " + refill.getColor().label());
        openCloseMechanism.close();
    }

    public void changeRefill(Refill newRefill) {
        System.out.println("Swapping refill: " + refill.getColor().label() + " -> " + newRefill.getColor().label());
        this.refill = newRefill;
    }

    public Color getColor(){ return refill.getColor(); }
}
