package ch08;

/**
 * リスト8.1 登録ができるかを確認するメソッド
 * リスト8.2 優待会員であるかを判定するメソッド
 * リスト8.B Ageオブジェクトを利用したメソッド
 * @author shuji.w6e
 */
public class Members {

    /**
     * 年齢を指定して、会員制サイトへ登録できるかを返す.
     * @param age 年齢
     * @return 18歳以上ならばtrueを、18歳未満ならばfalse
     */
    public static boolean canRegister(int age) {
        return 18 <= age;
    }

    /**
     * 優待会員かどうかを返す.
     * @param age 年齢
     * @param isRegisterMailMagazine メールマガジンに登録している場合にtrue
     * @param usePastMonth 前月の利用回数
     * @return 20歳以上であり、メールマガジンに登録してあり、かつ前月の利用回数が１回以上ならtrue
     */
    public static boolean isSpecialMember(int age, boolean isRegisterMailMagazine, int usePastMonth) {
        if (age < 20) return false;
        if (!isRegisterMailMagazine) return false;
        if (usePastMonth < 1) return false;
        return true;
    }

    /**
     * 年齢を指定して、会員制サイトへ登録できるかを返す.
     * @param age 年齢
     * @return 18歳以上ならばtrueを、18歳未満ならばfalse
     */
    public static boolean canRegister(Age age) {
        return 18 <= age.value;
    }
}
