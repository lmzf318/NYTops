package yyn.com.nytimetodaytop.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.squareup.picasso.Picasso;
import yyn.com.nytimetodaytop.R;
import yyn.com.nytimetodaytop.data.DataHolder;
import yyn.com.nytimetodaytop.data.TopsItem;
import yyn.com.nytimetodaytop.util.ActionUtil;
import yyn.com.nytimetodaytop.util.DataUtil;

import java.util.List;

/**
 * Created by jiy on 2017-04-12.
 */
public class TopsListAdapter extends BaseAdapter {
    private final static String TAG = "TopsListAdapter";

    private ListView listView = null;
    private Context context = null;

    public TopsListAdapter(ListView listView, Context context) {
        this.listView = listView;
        this.context = context;
    }

    @Override
    public int getCount() {
        return DataHolder.getInstance().topsSize();
    }

    @Override
    public Object getItem(int position) {
        return DataHolder.getInstance().getTops().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.tops_list_item, parent, false);

            viewHolder.sectionTextView = (TextView) convertView.findViewById(R.id.tops_list_section);
            viewHolder.titleTextView = (TextView) convertView.findViewById(R.id.tops_list_title);
            viewHolder.absTextView = (TextView) convertView.findViewById(R.id.tops_list_abs);
            viewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.tops_list_thumbnail);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        TopsItem item = DataHolder.getInstance().getTops().get(position);

        Log.d(TAG, "section: " + item.getSection());
        Log.d(TAG, "title: " + item.getTitle());
        Log.d(TAG, "abs: " + item.getAbs());
        viewHolder.sectionTextView.setText(item.getSection());
        viewHolder.titleTextView.setText(item.getTitle());
        viewHolder.absTextView.setText(item.getAbs());
        viewHolder.absTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.performItemClick(listView.findViewWithTag(getItem(position)), position, getItemId(position));
            }
        });

        if (!DataUtil.isEmpty(item.getImageUrl())) {
            Picasso.with(context)
                    .load(item.getImageUrl())
                    .placeholder(android.R.drawable.sym_def_app_icon)
                    .error(android.R.drawable.sym_def_app_icon)
                    .resizeDimen(R.dimen.tops_item_image_size, R.dimen.tops_item_image_size)
                    .centerInside()
                    .tag(context)
                    .into(viewHolder.thumbnail);
        }

        return convertView;
    }

    static class ViewHolder {
        TextView sectionTextView;
        TextView titleTextView;
        TextView absTextView;
        ImageView thumbnail;
    }
}
