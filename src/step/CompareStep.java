package step;

import element.Common;
import element.Element;
import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class CompareStep extends Step {

    CompareStep (Element node1, Element node2) {
        super(node1, node2);
        this.text = "COMPARE [" + node1.getIndex() + "] & ["+ node2.getIndex() + "]";
        this.initAnimationAndReverse();
    }


    @Override
    void setElementState() {
        node1.setFill(Color.YELLOWGREEN);
        node2.setFill(Color.YELLOWGREEN);
    }

    @Override
    Animation makeAnimation() {
        TranslateTransition tt1 = new TranslateTransition();
        tt1.setDuration(Duration.seconds(Common.DURATION/2));
        tt1.setCycleCount(2);
        tt1.setAutoReverse(true);
        tt1.setByY(-Common.HEIGHT);
        tt1.setNode(node1);

        TranslateTransition tt2 = new TranslateTransition();
        tt2.setDuration(Duration.seconds(Common.DURATION/2));
        tt2.setCycleCount(2);
        tt2.setAutoReverse(true);
        tt2.setByY(-Common.HEIGHT);
        tt2.setNode(node2);

        ParallelTransition pt = new ParallelTransition();
        pt.getChildren().addAll(tt1, tt2);

        return pt;
    }

    @Override
    Animation makeReverse() {
        return makeAnimation();
    }

}