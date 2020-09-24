package com.example.recycler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends RecyclerViewLogic {
    private static final String[] items={"lorem", "ipsum", "dolor",
            "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayoutManger(new LinearLayoutManager(this));
        setAdapter(new NiceAdapter());
    }
    public class NiceAdapter extends RecyclerView.Adapter<NiceAdapter.RawHolder> {
        @NonNull
        @Override
        public RawHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return (new RawHolder(getLayoutInflater().inflate(R.layout.row,parent,false)));
        }

        @Override
        public void onBindViewHolder(NiceAdapter.RawHolder holder, int position) {
                holder.bindModel(items[position]);
        }

        @Override
        public int getItemCount() {
            return items.length;
        }

        public class RawHolder extends RecyclerView.ViewHolder{
            TextView label;
            TextView size;
            ImageView icon;
            String template;

            public RawHolder(@NonNull View itemView) {
                super(itemView);
                label = itemView.findViewById(R.id.label);
                size = itemView.findViewById(R.id.size);
                icon = itemView.findViewById(R.id.icon);
                template=size.getContext().getString(R.string.size_template);
            }
            void bindModel(String item)
            {
                label.setText(item);
                size.setText(String.valueOf(item.length()));

                if(item.length() > 4)
                {
                    icon.setImageResource(R.drawable.ic_launcher_background);
                }else{
                    icon.setImageResource(R.drawable.ic_launcher_foreground);
                }
            }
        }

    }
}