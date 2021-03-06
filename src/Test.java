import AlgorithmData.Page;

import AlgorithmData.*;
import ReplacementAlgorithms.ReplacementAlgorithm;


import java.util.ArrayList;
import java.util.Random;

public class Test {

    private Page[] testSequance ;
    private Random random = new Random() ;

    private Algorithm algorithm ;
    private int hit = 0;
    private int miss = 0 ;

    private int numberOfFrames  ;
    private int rangeOfPageNumber ;
    private int pagesSequanceLength;

     Test( int numberOfFrames , int pagesSequanceLength ,int rangeOfPageNumber ){
        this.rangeOfPageNumber = rangeOfPageNumber;
        this.pagesSequanceLength =  pagesSequanceLength;
        this.numberOfFrames = numberOfFrames ;

    }

    Test(int numberOfFrames , Page[] pages ,  int rangeOfPageNumber ){
        this(numberOfFrames , pages.length , rangeOfPageNumber );
        testSequance = pages;

    }

    public void createTestSequance(int seed){
         random.setSeed(seed);
        testSequance = new Page[pagesSequanceLength];
        for(int count = 0 ; count < pagesSequanceLength ; count++ ){
            int pageNumber = random.nextInt(rangeOfPageNumber);
            Page page = new Page(pageNumber);
            testSequance[count] = page ;
        }
    }

    void randomTest(Algorithm algorithm){
         if(testSequance == null)
             createTestSequance(PageReplacementAlgorithms.seed);

        algorithm = algorithm ;
        for(int count = 0 ; count < pagesSequanceLength ; count++ ){
            Page page = testSequance[count];
            boolean cond = algorithm.insert(page);

            if(cond == true) {
                algorithm.print();
                ++miss;
            }
            else
                System.out.println();
        }
    }

    public Page[] getTestSequance() {
        return testSequance;
    }

    public int getHit() {
         hit  = pagesSequanceLength - miss ;
        return hit;
    }

    public int getMiss() {
        return miss;
    }
}
