
public class Link {
    private long src;
    private short srcPort;
    private long dst;
    private short dstPort;


    public Link(long srcId, short srcPort, long dstId, short dstPort) {
        this.src = srcId;
        this.srcPort = srcPort;
        this.dst = dstId;
        this.dstPort = dstPort;
    }

    // Convenience method
    public Link(long srcId, int srcPort, long dstId, int dstPort) {
        this.src = srcId;
        this.srcPort = (short) srcPort;
        this.dst = dstId;
        this.dstPort = (short) dstPort;
    }

    public long getSrc() {
        return src;
    }

    public short getSrcPort() {
        return srcPort;
    }
    public long getDst() {
        return dst;
    }

    public short getDstPort() {
        return dstPort;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (dst ^ (dst >>> 32));
        result = prime * result + dstPort;
        result = prime * result + (int) (src ^ (src >>> 32));
        result = prime * result + srcPort;
        return result;
    }
    
    @Override
    public String toString() {
        return "Link [src=" + this.src 
                + " outPort="
                + srcPort 
                + ", dst=" + this.dst
                + ", inPort="
                + dstPort
                + "]";
    }

}

