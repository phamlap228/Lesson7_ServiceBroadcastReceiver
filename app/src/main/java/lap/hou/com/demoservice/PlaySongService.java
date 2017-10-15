package lap.hou.com.demoservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class PlaySongService extends Service {
    private MediaPlayer mMediaPlayer;
    public PlaySongService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        // Service này là loại không giàng buộc (Un bounded)
        // Vì vậy method này ko bao giờ được gọi.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //Tạo đối tượng Media Player, chơi file nhac của bạn
        mMediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.emgaimua_anhkhang);
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
        //chơi nhạc
        mMediaPlayer.start();
        return START_STICKY;
    }
    //Hủy bỏ dịch vụ.
    @Override
    public void onDestroy() {
        // Giải phóng nguồn dữ nguồn phát nhạc.
        mMediaPlayer.release();
        super.onDestroy();
    }
}
