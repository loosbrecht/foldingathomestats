package com.loos.fahstats.views.foldingathomestats;

import com.github.appreciated.apexcharts.ApexCharts;
import com.github.appreciated.apexcharts.ApexChartsBuilder;
import com.github.appreciated.apexcharts.config.builder.ChartBuilder;
import com.github.appreciated.apexcharts.config.builder.StrokeBuilder;
import com.github.appreciated.apexcharts.config.builder.TitleSubtitleBuilder;
import com.github.appreciated.apexcharts.config.builder.XAxisBuilder;
import com.github.appreciated.apexcharts.config.chart.Type;
import com.github.appreciated.apexcharts.config.chart.builder.ZoomBuilder;
import com.github.appreciated.apexcharts.config.stroke.Curve;
import com.github.appreciated.apexcharts.config.subtitle.Align;
import com.github.appreciated.apexcharts.helper.Series;
import com.loos.fahstats.entity.Score;
import com.vaadin.flow.component.html.Div;

import java.util.List;

public class LineChart extends Div {
    public LineChart(List<Score> scores) {
        String[] scoreData = scores.stream().map(s -> String.valueOf(s.getScore())).toArray(String[]::new);
        String[] dates = scores.stream().map(Score::getDateText).toArray(String[]::new);
        ApexCharts lineChart = ApexChartsBuilder.get()
                .withChart(ChartBuilder.get()
                        .withType(Type.line)
                        .withZoom(ZoomBuilder.get()
                                .withEnabled(false)
                                .build())
                        .build())
                .withStroke(StrokeBuilder.get()
                        .withCurve(Curve.straight)
                        .build())
                .withTitle(TitleSubtitleBuilder.get()
                        .withText("Daily scores")
                        .withAlign(Align.left)
                        .build())
                .withXaxis(XAxisBuilder.get()
                        .withCategories(dates)
                        .build())
                .withSeries(new Series<>("score", scoreData))
                .build();
        add(lineChart);
        setWidth("100%");
    }
}
