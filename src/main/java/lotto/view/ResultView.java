package lotto.view;

import lotto.dto.LottoPrize;
import lotto.dto.LottoResult;
import lotto.dto.LottoTicketInfo;

import java.util.List;

public class ResultView {

    public static void printLottoTicketInfo(LottoTicketInfo ticketInfo) {
        List<String> tickets = ticketInfo.getTicketInfo();
        int size = tickets.size();
        System.out.println(size + " 개를 구매했습니다.");
        tickets.forEach(ticket -> {
            System.out.println("[" + ticket + "]");
        });
    }

    public static void printLottoResult(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int count = 3; count <= 6; count++) {
            LottoPrize prize = LottoPrize.of(count);
            int prizeCount = result.getLottoPrizeCount(prize);

            System.out.println(count + "개 일치 (" + prize.getPrize() + "원) - " + prizeCount + "개");
        }
        System.out.println("총 수익률은 " + result.getReturnRate() + "입니다.");
    }
}