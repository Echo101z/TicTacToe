package com.game101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

int activeplayer=0;
 int[] gamest= {2,2,2,2,2,2,2,2,2};
int [][] winpos={{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
boolean gameactive=true;
    public void dropin(View view)
    {
        ImageView counter=(ImageView) view;

        System.out.println(counter.getTag().toString());
       int tappedcounter= Integer.parseInt(counter.getTag().toString());
        if(gamest[tappedcounter]==2 && gameactive) {
            gamest[tappedcounter] = activeplayer;
            counter.setTranslationY(-1000f);

            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.o);
                activeplayer = 1;
            } else {
                counter.setImageResource(R.drawable.xy);
                activeplayer = 0;    //alt images
            }
            counter.animate().translationYBy(1000f).rotation(360f).setDuration(300);

            for(int[] winningpos: winpos)
            {
                if(gamest[winningpos[0]]==gamest[winningpos[1]] && gamest[winningpos[1]]==gamest[winningpos[2]] && gamest[winningpos[0]]!=2)
                {gameactive=false;
                    String wo="Blue";
                    if(gamest[winningpos[0]]==0) {
                        wo = "Red";
                    }

                    System.out.println(gamest[winningpos[0]]);
                    TextView ti=(TextView)findViewById(R.id.wintext);
                    LinearLayout li=(LinearLayout)findViewById(R.id.playagain);

                    ti.setText(wo+ " has won");


                    li.setVisibility(View.VISIBLE);



                }else{
                    boolean tie=true;

                    for(int counterst:gamest) {
                        if (counterst == 2) {
                            tie = false;
                        }
                    }

                    if(tie)
                    {
                        TextView ti=(TextView)findViewById(R.id.wintext);
                        LinearLayout li=(LinearLayout)findViewById(R.id.playagain);

                        ti.setText("its a tie");


                        li.setVisibility(View.VISIBLE);
                }

            }





        }














    }}


public void playag(View view){
gameactive=true;
    LinearLayout li=(LinearLayout)findViewById(R.id.playagain);

    li.setVisibility(View.INVISIBLE);

    activeplayer=0;

for(int i=0;i< gamest.length;i++){

    gamest[i]=2;
}

    GridLayout gl=(GridLayout)findViewById(R.id.gl);
      for(int i=0;i<gl.getChildCount();i++)
      {
          ((ImageView)gl.getChildAt(i)).setImageResource(0);
      }




}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
