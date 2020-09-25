package com.example.recycler;

import android.app.Activity;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewLogic extends Activity {
    private RecyclerView rv;

    private RecyclerView getRecyclerView()
    {
        if(rv == null)
        {
            rv = new RecyclerView(this);
            rv.setHasFixedSize(true);
            setContentView(rv);
        }
        return rv;
    }

    public void setLayoutManger(RecyclerView.LayoutManager manager)
    {
        getRecyclerView().setLayoutManager(manager);
    }

    public RecyclerView getRv()
    {
        return rv;
    }

    private RecyclerView.Adapter getAdapter()
    {
        return getRecyclerView().getAdapter();
    }

    public void setAdapter(RecyclerView.Adapter adapter)
    {
        getRecyclerView().setAdapter(adapter);
    }
}
