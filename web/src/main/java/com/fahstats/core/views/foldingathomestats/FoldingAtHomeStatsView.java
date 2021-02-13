package com.fahstats.core.views.foldingathomestats;

import com.fahstats.core.entity.Score;
import com.fahstats.core.entity.ScoreList;
import com.fahstats.core.entity.Totals;
import com.fahstats.core.views.main.MainView;
import com.fahstats.core.repo.UserStatsRepo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

@Route(value = "home", layout = MainView.class)
@PageTitle("Folding At Home Stats")
@CssImport(value = "./styles/views/foldingathomestats/folding-at-home-stats-view.css", include = "lumo-badge")
@JsModule("@vaadin/vaadin-lumo-styles/badge.js")
@RouteAlias(value = "", layout = MainView.class)
public class FoldingAtHomeStatsView extends Div implements AfterNavigationObserver {

    private final H2 dailyScore = new H2();
    private final H2 monthlyScore = new H2();
    private final H2 yearlyScore = new H2();
    private final H2 grandTotalScore = new H2();
    ScoreList scoreList;
    private Grid<Score> grid = new Grid<>();
    private LineChart lineChart;
    private final UserStatsRepo userStatsRepo;

    public FoldingAtHomeStatsView(@Autowired UserStatsRepo userStatsRepo) {
        this.userStatsRepo = userStatsRepo;
        setId("folding-at-home-stats-view");
        Board board = new Board();
        board.addRow(createBadge("Daily", dailyScore, "primary-text", "badge"),
                createBadge("Monthly", monthlyScore, "success-text", "badge success"),
                createBadge("Yearly", yearlyScore, "error-text", "badge error"),
                createBadge("Grand Total", grandTotalScore, "error-text", "badge error"));


        scoreList = userStatsRepo.AllData();
        board.add(new LineChart(scoreList.getListWithEmptyValues()));

        grid.addColumn(Score::getDateText).setHeader("Date");
//        grid.addColumn(new ComponentRenderer<>(item -> {
//            Span span = new Span(item.getStatus());
//            span.getElement().etThemeList().add(item.getTheme());
//            return span;
//        })).setFlexGrow(0).setWidth("100px").setHeader("Status");
        grid.addColumn(Score::getScore).setHeader("Score");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);

        WrapperCard gridWrapper = new WrapperCard("wrapper", new Component[]{new H3("Score list"), grid}, "card");
        board.addRow(gridWrapper);

        add(board);
    }

    private WrapperCard createBadge(String title, H2 h2, String h2ClassName, String badgeTheme) {
        Span titleSpan = new Span(title);
        titleSpan.getElement().setAttribute("theme", badgeTheme);

        h2.addClassName(h2ClassName);


        return new WrapperCard("wrapper", new Component[]{titleSpan, h2}, "card", "space-m");
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {

        Totals total = userStatsRepo.GetTotals();
        dailyScore.setText(String.valueOf(total.data.getOrDefault("Day", 1234L)));
        monthlyScore.setText(String.valueOf(total.data.getOrDefault("Month", 1234L)));
        yearlyScore.setText(String.valueOf(total.data.getOrDefault("Year", 1234L)));
        grandTotalScore.setText(String.valueOf(total.data.getOrDefault("GrandTotal", 1234L)));

        // Grid
        var data = scoreList.getListWithEmptyValues();
        if (data != null) {
             Collections.reverse(data);
            grid.setItems(data);
        }
    }
}
