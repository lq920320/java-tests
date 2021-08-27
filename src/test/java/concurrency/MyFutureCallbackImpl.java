package concurrency;

import com.google.common.util.concurrent.FutureCallback;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * 实现 future callback 接口
 *
 * @author zetu
 * @date 2021/8/5
 */
public class MyFutureCallbackImpl implements FutureCallback<String> {

    private StringBuilder builder = new StringBuilder();

    @Override
    public void onSuccess(@Nullable String s) {
        builder.append(s).append(" successfully");
    }

    @Override
    public void onFailure(Throwable throwable) {
        builder.append(throwable.toString());
    }

    public String getCallbackResult() {
        return builder.toString();
    }
}
