package lotto.domain;

import lotto.util.LottoNumberParser;

import java.util.Set;

public class Lotto {

    public static final int LOTTO_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(String numbers) {
        Set<LottoNumber> parsedNumbers = LottoNumberParser.parseToSet(numbers);
        validCheck(parsedNumbers);
        return new Lotto(parsedNumbers);
    }

    public static Lotto of(Set<LottoNumber> numbers) {
        validCheck(numbers);
        return new Lotto(numbers);
    }

    private static void validCheck(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }
    }

    public Match getMatch(Lotto other) {
        int count = (int) lottoNumbers.stream()
                .filter(other.lottoNumbers::contains)
                .count();
        return Match.of(count);
    }

    @Override
    public String toString() {
        return LottoNumberParser.parseToString(lottoNumbers);
    }
}