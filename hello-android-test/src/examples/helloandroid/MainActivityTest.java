package examples.helloandroid;

import static android.test.TouchUtils.*;

import java.io.IOException;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * リスト13.13 MainActivityTestクラスの初期化
 * リスト13.14 MainActivityTestの初期状態テスト
 * リスト13.15 ハッピーパスのテスト
 * リスト13.16 認証に失敗するシナリオのテスト
 * リスト13.17 認証時に例外が発生するエラーシナリオのテスト
 * @author shuji.w6e
 */
public class MainActivityTest 
             extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity activity;
    EditText userIdEditText;
    EditText passwdEditText;
    Button pushButton;
    TextView statusTextView;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
        userIdEditText = (EditText) activity.findViewById(R.id.userIdEditText);
        passwdEditText = (EditText) activity.findViewById(R.id.passwordEditText);
        pushButton = (Button) activity.findViewById(R.id.pushButton);
        statusTextView = (TextView) activity.findViewById(R.id.statusTextView);
    }

    public void testPreConditions() throws Exception {
        assertEquals("", userIdEditText.getText().toString());
        assertEquals("", passwdEditText.getText().toString());
        assertFalse(pushButton.isEnabled());
        assertEquals("", statusTextView.getText().toString());
    }

    public void testHappyPath() throws Exception {
        // 1. userIdEditTextを選択し、「duke」と入力する
        clickView(this, userIdEditText);
        sendKeys("D U K E");
        assertEquals("duke", userIdEditText.getText().toString());
        // 2. passwdEditTextを選択し、「3micro」と入力する
        clickView(this, passwdEditText);
        sendKeys("3 M I C R O");
        assertEquals("3micro", passwdEditText.getText().toString());
        // 3. プッシュボタンをクリックする
        clickView(this, pushButton);
        // 4. ステータスバーに「ようこそ、dukeさん」と表示されていることを確認する
        assertEquals("ようこそ、dukeさん", statusTextView.getText().toString());
    }

    public void testユーザ認証に失敗する() throws Exception {
        // 1. userIdEditTextを選択し、「duke」と入力する
        clickView(this, userIdEditText);
        sendKeys("D U K E");
        assertEquals("duke", userIdEditText.getText().toString());
        // 2. passwdEditTextを選択し、「0r4c1e」と入力する
        clickView(this, passwdEditText);
        sendKeys("0 R 4 C 1 E");
        assertEquals("0r4c1e", passwdEditText.getText().toString());
        // 3. プッシュボタンをクリックする
        clickView(this, pushButton);
        // 4. ステータスバーに「ユーザIDとパスワードを正しく入力してください」と表示されていることを確認する
        assertEquals("ユーザIDとパスワードを正しく入力してください", statusTextView.getText().toString());
    }

    public void testユーザ認証で例外が発生する() throws Exception {
        activity.authService = new AuthService() {
            @Override
            public boolean login(AuthUser authUser) throws IOException {
                throw new IOException("Error");
            }
        };
        // 1. userIdEditTextを選択し、「duke」と入力する
        clickView(this, userIdEditText);
        sendKeys("D U K E");
        assertEquals("duke", userIdEditText.getText().toString());
        // 2. passwdEditTextを選択し、「3micro」と入力する
        clickView(this, passwdEditText);
        sendKeys("3 M I C R O");
        assertEquals("3micro", passwdEditText.getText().toString());
        // 3. プッシュボタンをクリックする
        clickView(this, pushButton);
        // 4. ステータスバーに「システムエラー」と表示されていることを確認する
        assertEquals("システムエラー", statusTextView.getText().toString());
    }

}
