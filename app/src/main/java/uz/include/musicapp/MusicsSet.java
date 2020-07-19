package uz.include.musicapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
public class MusicsSet extends ArrayAdapter<Music> {
    public MusicsSet (Context context, ArrayList<Music> object) {
        super(context, 0, object);
    }
    @NotNull
    @Override
    public View getView(int munozara,
                        @Nullable
                                View MaktubView,
                        @NotNull
                                ViewGroup parent
    )
    {
        View RuyxatView = MaktubView;
        if(RuyxatView == null) {
            RuyxatView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,
                    parent,
                    false
            );
        }
        Music cSuz= (Music) getItem(munozara);

        TextView musicTV = (TextView)
                RuyxatView.findViewById(R.id.music_view);
        assert cSuz != null;

        musicTV.setText(cSuz.IsmOfMusic());

        TextView artistTV = (TextView)
                RuyxatView.findViewById(R.id.artist_view);

        artistTV.setText(cSuz.IsmOfArtist());

        return RuyxatView;
    }

}
