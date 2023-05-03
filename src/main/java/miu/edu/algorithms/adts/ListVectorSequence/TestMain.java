package miu.edu.algorithms.adts.ListVectorSequence;

public class TestMain {
    public static void main(String[] args) {
        ISequence seqA = new ASequence(1);
        System.out.println(seqA.insertAtRank(0, "3"));
        System.out.println(seqA.insertAtRank(0, "2"));
        System.out.println(seqA.insertAtRank(2, "4"));
        Position p6 = seqA.insertAtRank(3, "6");
        System.out.println(seqA.insertAtRank(4, "8"));
        Position p0 = seqA.insertAtRank(0, "0");
        seqA.insertAtRank(1, "1");
        seqA.insertAtRank(5, "5");
        System.out.println(seqA);
        seqA.insertAfter(p6, "7");
        System.out.println(seqA);
        seqA.insertBefore(p0, "-1");
        System.out.println(seqA);
        System.out.println(seqA.removeAtRank(5));
        System.out.println(seqA.removeAtRank(6));
        System.out.println(seqA);
        System.out.println(seqA.removeAtRank(2));
        System.out.println(seqA);
        System.out.println(seqA.removeAtRank(0));
        System.out.println(seqA.removeAtRank(0));
        System.out.println(seqA);

        ISequence seqL = new LSequence();
        Position p3 = seqL.insertFirst("3");
        System.out.println(seqL);
        Position p2 = seqL.insertBefore(p3, "2");
        System.out.println(seqL);
        Position p4 = seqL.insertAtRank(2, "4");
        System.out.println(seqL);
        p6 = seqL.insertAtRank(3, "6");
        System.out.println(seqL);
        p0 = seqL.insertFirst("0");
        System.out.println(seqL);
        Position p1 = seqL.insertAtRank(1, "1");
        seqL.insertAtRank(5, "5");
        System.out.println(seqL);
        seqL.insertAfter(p6, "7");
        System.out.println(seqL);
        seqL.insertBefore(p0, "-1");
        System.out.println(seqL);
        System.out.println(seqL.removeAtRank(5));
        System.out.println(seqL.removeAtRank(6));
        System.out.println(seqL);
        System.out.println(seqL.removeAtRank(2));
        System.out.println(seqL);
        System.out.println(seqL.removeAtRank(0));
        System.out.println(seqL.removeAtRank(0));
        System.out.println(seqL);

    }
}
