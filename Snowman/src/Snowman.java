import com.sun.prism.paint.Color;
import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.paint.Paint;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.paint.Color.*;

import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.WHITE;


class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = new Pane();

        root.setBackground(new Background(new BackgroundFill(BLUE, null, null)));

        Circle c1 = new Circle();
        c1.setFill(WHITE);
        Circle c2 = new Circle();
        c2.setFill(WHITE);
        Circle c3 = new Circle();
        c3.setFill(WHITE);


c1.centerXProperty().bind(new DoubleBinding() {{
    super.bind(root.widthProperty());
}
    @Override
    protected double computeValue() {
        return root.widthProperty().get()/2;
    }
});
c1.centerYProperty().bind(new DoubleBinding() {{
    super.bind (root.heightProperty());
}
    @Override
    protected double computeValue() {
        return root.heightProperty().get()/12;
    }
});
c1.radiusProperty().bind(new DoubleBinding() {{
    super.bind(root.heightProperty());
}
    @Override
    protected double computeValue() {
        return root.heightProperty().get()/12;
    }
});
        c2.centerXProperty().bind(new DoubleBinding() {{
            super.bind(root.widthProperty());
        }
            @Override
            protected double computeValue() {
                return root.widthProperty().get()/2;
            }
        });
        c2.centerYProperty().bind(new DoubleBinding() {{
            super.bind (root.heightProperty());
        }
            @Override
            protected double computeValue() {
                return root.heightProperty().get()/3;
            }
        });
        c2.radiusProperty().bind(new DoubleBinding() {{
            super.bind(root.heightProperty());
        }
            @Override
            protected double computeValue() {
                return root.heightProperty().get()/6;
            }
        });

        c3.centerXProperty().bind(new DoubleBinding() {{
            super.bind(root.widthProperty());
        }
            @Override
            protected double computeValue() {
                return root.widthProperty().get()/2;
            }
        });
        c3.centerYProperty().bind(new DoubleBinding() {{
            super.bind (root.heightProperty());
        }
            @Override
            protected double computeValue() {
                return root.heightProperty().get()*9/12;
            }
        });
        c3.radiusProperty().bind(new DoubleBinding() {{
            super.bind(root.heightProperty());
        }
            @Override
            protected double computeValue() {
                return root.heightProperty().get()/4;
            }
        });


       root.getChildren().addAll(c1, c2,c3);
        primaryStage.setTitle("SnowmanFX");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
