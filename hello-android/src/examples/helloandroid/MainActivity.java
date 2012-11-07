package examples.helloandroid;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * リスト13.7 MVCパターンを適用したMainActivityクラス
 * @author shuji.w6e
 */
public class MainActivity extends Activity {
    // TODO 本実装に差し替える
    AuthService authService = new AuthServiceStub();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getUserIdEditText().addTextChangedListener(new EditTextWatcher());
        getPasswdEditText().addTextChangedListener(new EditTextWatcher());
        getPushButton().setOnClickListener(new PushButtonListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    EditText getUserIdEditText() {
        return (EditText) findViewById(R.id.userIdEditText);
    }

    EditText getPasswdEditText() {
        return (EditText) findViewById(R.id.passwordEditText);
    }

    Button getPushButton() {
        return (Button) findViewById(R.id.pushButton);
    }

    class EditTextWatcher implements TextWatcher {

        @Override
        public void onTextChanged(CharSequence text, int arg1, int arg2, int arg3) {
            if (getUserIdEditText().length() < 4 || getPasswdEditText().length() < 4) {
                getPushButton().setEnabled(false);
            } else {
                getPushButton().setEnabled(true);
            }
        }

        @Override
        public void beforeTextChanged(CharSequence text, int arg1, int arg2, int arg3) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }

    }

    class PushButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String userId = getUserIdEditText().getText().toString();
            String password = getPasswdEditText().getText().toString();
            final AuthUser authUser = new AuthUser(userId, password);
            final TextView status
                      = ((TextView) findViewById(R.id.statusTextView));
            new AsyncTask<Object, Object, String>() {
                @Override
                protected String doInBackground(Object... params) {
                    try {
                        return authService.login(authUser) ?
                                "ユーザIDとパスワードを正しく入力してください" :
                                "ようこそ、" + authUser.userId + "さん";
                    } catch (Exception e) {
                        return "システムエラー";
                    }
                }

                @Override
                protected void onPostExecute(String result) {
                    status.setText(result);
                }
            }.execute();
        }
    }

}
