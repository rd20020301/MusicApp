package uz.include.musicapp;
public class Music {
    private String IsmOfArtist;
    private String IsmOfMusic;
    private int mMediaPlayeresourceId;
    public Music (String OfArtist,String OfMusic, int mediaPlayeresourceId) {
        IsmOfArtist = OfArtist;
        IsmOfMusic = OfMusic;
        mMediaPlayeresourceId = mediaPlayeresourceId;

    }

    public String IsmOfArtist() {

        return IsmOfArtist;
    }
    public String IsmOfMusic() {

        return IsmOfMusic;
    }

    public int getMediaPlayeresourceId(){
        return mMediaPlayeresourceId;
    }



}
