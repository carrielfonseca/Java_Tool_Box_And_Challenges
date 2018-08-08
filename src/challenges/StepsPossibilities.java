package challenges;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Inspired by https://www.youtube.com/watch?v=5o-kdjv7FD0&t=127s
// Amazon challenge

public class StepsPossibilities {
	
	private int numberOfSteps;
	private int numberOfPermutations = 0; // how many ways you can go up the stairs
	private Set<Integer> setOfMoves = new HashSet<Integer>(); // Set 
	private Set<List<Integer>> solutions =  new HashSet<>();
		
	StepsPossibilities(int numberOfSteps, Set<Integer> setOfMoves) {
		this.numberOfSteps = numberOfSteps;
		this.setOfMoves = setOfMoves;
		List<Integer> possibleSolution = new ArrayList<>();
		stepUp(0, possibleSolution);
	}
	
	private void stepUp(int currentStep, List<Integer> possibleSolution) {		
		if (currentStep > numberOfSteps) {
			possibleSolution.remove(possibleSolution.size() - 1);
			return;
		} else if (currentStep == numberOfSteps) {
			solutions.add((new ArrayList<Integer> (possibleSolution)));
			possibleSolution.remove(possibleSolution.size() - 1);
			numberOfPermutations++;
			return;
		}		
		for (Integer i : this.setOfMoves) {
			possibleSolution.add(i);
			stepUp(currentStep + i, possibleSolution);
		}
		if (!possibleSolution.isEmpty()) {
			possibleSolution.remove(possibleSolution.size() - 1);
		}
	}
	
	private static void printList(List<Integer> list) {
		for (Integer i: list) {
			System.out.print(i + ", ");
		}
	}	

	public static void main(String[] args) {
		HashSet<Integer> setOfMoves = new HashSet<>();
		setOfMoves.add(1);
		setOfMoves.add(2);
		setOfMoves.add(3);
		StepsPossibilities sp = new StepsPossibilities(18, setOfMoves);
		System.out.println(sp.numberOfPermutations);
		for (List<Integer> list : sp.solutions) {
			printList(list);
			System.out.println("");
		}		
		System.out.println(sp.solutions.size());
	}

}
