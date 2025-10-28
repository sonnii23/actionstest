package de.hs_el.streekmann.algodat.aufgabe1;

import de.hs_el.streekmann.algodat.Logging;

import java.util.logging.*;
import java.util.Iterator;

final class Main {

    private static final Logger logger = Logging.getLogger(Main.class.getName());
    private static final String SPACE = "  ";
    private static final String NEW_LINE = "\n";
    private static int numberOfElements = 10;

	public static void main(String[] args) {
        if (args.length > 0) {
			numberOfElements = Integer.parseInt(args[0]);
		}

        fillAndPrintList(new LinkedList<>());
        fillAndPrintList(new ArrayList<>());
	}

    private static void fillAndPrintList(List<Integer> list) {
        fillList(list, numberOfElements);
        printListInForLoop(list);
        printListInForLoopWithIterator(list);
        printListInForeachLoop(list);
        printIteratorCount(list);
        printGetCount(list);
    }

    private static void fillList(List<Integer> list, int numberOfElements) {
        for (int i = 1; i <= numberOfElements; i++) {
            list.add(i * i);
        }
    }

    private static <E> void printListInForLoopWithIterator(List<E> list) {
        StringBuilder builder = createStringBuilderWithHeading(list, "for loop with iterator");
        for (Iterator<E> iterator = list.iterator(); iterator.hasNext();) {
            addElementToString(builder, iterator.next());
        }
        addElementToString(builder, list.iteratorCount());
        builder.append("TEST");
        logString(builder);
    }

    private static <E> void printIteratorCount(List<E> list){
        StringBuilder builder = createStringBuilderWithHeading(list, "Iterator count: " + list.iteratorCount());
        logString(builder);
    }
    private static <E> void printGetCount(List<E> list){
        StringBuilder builder = createStringBuilderWithHeading(list, "Get count: " + list.getCount());
        logString(builder);
    }

    private static <E> void printListInForeachLoop(List<E> list) {
        StringBuilder builder = createStringBuilderWithHeading(list, "foreach loop");
        for (E element : list) {
            addElementToString(builder, element);
		}
        logString(builder);
    }

	private static <E> void printListInForLoop(List<E> list) {
        StringBuilder builder = createStringBuilderWithHeading(list, "for loop");
        for (int i = 0; i < list.size(); i++) {
            addElementToString(builder, list.get(i));
		}
        logString(builder);
    }

    private static <E> StringBuilder createStringBuilderWithHeading(List<E> list, String loopType) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("--- %s printed in %s ---%s", list.getClass().getSimpleName(), loopType, NEW_LINE));
        return builder;
    }

    private static <E> void addElementToString(StringBuilder builder, E element) {
        builder.append(element).append(SPACE);
    }

    private static void logString(StringBuilder builder) {
        builder.append(NEW_LINE);
        String result = builder.toString();
        logger.info(result);
    }
}
