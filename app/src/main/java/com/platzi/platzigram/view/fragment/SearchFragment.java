package com.platzi.platzigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.platzi.platzigram.R;

import de.clemenskeppler.materialsearchview.MaterialSearchView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    MaterialSearchView materialSearchView;
    SearchView searchView;
    RecyclerView results;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        showToolbar("", false, view);
        materialSearchView = (MaterialSearchView) view.findViewById(R.id.materialSearchView);
        searchView = materialSearchView.getSearchView();
        results = materialSearchView.getSearchResults();
        return view;
    }

    public boolean onCreateOptionsMenu(Menu menu){
        //Inflamos y traemos el layout menu_buscador, cargando el archivo de recursos
        getActivity().getMenuInflater().inflate(R.menu.menu_buscador, menu);
        //Encontramos a la barra de busqueda
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        //SearchView.setOnQueryTextListener(this);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    public void showToolbar(String tittle, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }
}
