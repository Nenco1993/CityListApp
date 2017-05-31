package com.example.neven.citylistapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.neven.citylistapp.MyApplication;
import com.example.neven.citylistapp.R;
import com.example.neven.citylistapp.adapters.ListAdapter;
import com.example.neven.citylistapp.dagger.modules.ListModule;
import com.example.neven.citylistapp.models.City;
import com.example.neven.citylistapp.presenters.ListPresenter;
import com.example.neven.citylistapp.views.ListCityView;

import javax.inject.Inject;
import java.util.List;

public class MainActivity extends BaseActivity implements ListCityView, ListAdapter.CityClickListener {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    ListPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((MyApplication) getApplication()).appComponent.newListSubComponent(new ListModule(this, this)).inject(this);

        LinearLayoutManager manager = new LinearLayoutManager(getBaseContext());

        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(mDividerItemDecoration);

        presenter.downloadData();


    }

    @Override
    public void showData(List<City> listCity) {

        ListAdapter adapter = new ListAdapter(listCity, getBaseContext());
        recyclerView.setAdapter(adapter);
        adapter.setCityClickListener(this);

        // we hide the progress bar here but since its not mentioned I didnt use it.


    }

    @Override
    public void onCityClicked(City city) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("city", city);
        Intent intent = new Intent(getBaseContext(), MapsActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
