package jmsmarcelo.clockdesktopjavafx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.time.LocalDateTime;

public class ClockController {
    @FXML
    private Group analogView;
    @FXML
    private Group secondPointer;
    @FXML
    private Group minutePointer;
    @FXML
    private Group hourPointer;
    @FXML
    private Group digitalView;
    @FXML
    private Group digitalH;
    @FXML
    private Group digitalHH;
    @FXML
    private SVGPath digitalColon;
    @FXML
    private Group digitalM;
    @FXML
    private Group digitalMM;
    @FXML
    private Group digitalS;
    @FXML
    private Group digitalSS;
    private LocalDateTime previousTime = LocalDateTime.now();
    private LocalDateTime currentTime;
    private Timeline analog;
    private Timeline digital;
    private Rotate rs;
    private Rotate rm;
    private Rotate rh;

    @FXML
    private void initialize() {
        analogView.setVisible(true);
        digitalView.setVisible(false);
        setDigitalView(previousTime, null);
        rs = new Rotate(6 * previousTime.getSecond(), 300, 300);
        secondPointer.getTransforms().add(rs);
        rm = new Rotate((0.1 * previousTime.getSecond()) + (6 * previousTime.getMinute()), 300, 300);
        minutePointer.getTransforms().add(rm);
        rh = new Rotate((0.0083333333333333 * previousTime.getSecond()) + (0.5 * previousTime.getMinute()) +
                (30 * previousTime.getHour()), 300, 300);
        hourPointer.getTransforms().add(rh);
        analog = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            previousTime = LocalDateTime.now();
            setAnalogTime(previousTime);
        }));
        analog.setCycleCount(Timeline.INDEFINITE);
        digital = new Timeline(new KeyFrame(Duration.seconds(0.5), e -> {
            currentTime = LocalDateTime.now();
            if(!previousTime.isEqual(currentTime)) {
                setDigitalView(currentTime, previousTime);
            }
            digitalColon.setOpacity((previousTime.getSecond() == currentTime.getSecond() ? 0: 100));
            previousTime = currentTime;
        }));
        digital.setCycleCount(Timeline.INDEFINITE);
        if(analogView.isVisible()) analog.play();
        else digital.play();
    }
    private int[] digitalMap(int d) {
        return switch (d) {
            case 9 -> new int[] {100, 100, 100, 100, 0, 100, 100};
            case 8 -> new int[] {100, 100, 100, 100, 100, 100, 100};
            case 7 -> new int[] {100, 0, 100, 0, 0, 100, 0};
            case 6 -> new int[] {100, 100, 0, 100, 100, 100, 100};
            case 5 -> new int[] {100, 100, 0, 100, 0, 100, 100};
            case 4 -> new int[] {0, 100, 100, 100, 0, 100, 0};
            case 3 -> new int[] {100, 0, 100, 100, 0, 100, 100};
            case 2 -> new int[] {100, 0, 100, 100, 100, 0, 100};
            case 1 -> new int[] {0, 0, 100, 0, 0, 100, 0};
            default -> new int[] {100, 100, 100, 0, 100, 100, 100};
        };
    }
    private void setDigitalNumber(Group g, int d) {
        for(int i = 0; i < g.getChildren().size(); i++) {
            g.getChildren().get(i).setOpacity(digitalMap(d)[i]);
        }
    }
    private void setDigitalView(LocalDateTime ctime, LocalDateTime ptime) {
        if(ptime == null || (ptime.getHour() != ctime.getHour())) {
            setDigitalNumber(digitalH, ctime.getHour() / 10);
            setDigitalNumber(digitalHH, ctime.getHour() % 10);
        }
        if(ptime == null || (ptime.getMinute() != ctime.getMinute())) {
            setDigitalNumber(digitalM, ctime.getMinute() / 10);
            setDigitalNumber(digitalMM, ctime.getMinute() % 10);
        }
        setDigitalNumber(digitalS, ctime.getSecond() / 10);
        setDigitalNumber(digitalSS, ctime.getSecond() % 10);
    }
    private void setAnalogTime(LocalDateTime ctime) {
        rs.setAngle(6 * ctime.getSecond());
        rm.setAngle((0.1 * ctime.getSecond()) + (6 * ctime.getMinute()));
        rh.setAngle((0.0083333333333333 * ctime.getSecond()) + (0.5 * ctime.getMinute()) + (30 * ctime.getHour()));
    }

    public void handleBtnChangeClock(ActionEvent ae) {
        if(!analogView.isVisible()) {
            setAnalogTime(LocalDateTime.now());
            analog.play();
            digital.stop();
        } else {
            setDigitalView(LocalDateTime.now(), null);
            digital.play();
            analog.stop();
        }
        analogView.setVisible(!analogView.isVisible());
        digitalView.setVisible(!analogView.isVisible());
    }
}