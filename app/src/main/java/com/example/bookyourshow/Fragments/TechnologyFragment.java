package com.example.bookyourshow.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.bookyourshow.APIS.OnItemClickListener;
import com.example.bookyourshow.Adapters.BuzzAdapter;
import com.example.bookyourshow.APIS.NewsApiClient;
import com.example.bookyourshow.Models.TopHeadlinesRequest;
import com.example.bookyourshow.Models.ArticleResponse;
import com.example.bookyourshow.R;

public class TechnologyFragment extends Fragment implements OnItemClickListener {

    private RecyclerView hBuzzEntertainmentRecyclerView;
    private ArticleResponse hBuzzTechnologyArticleResponse;
    private WebView hBuzzTechnologyWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_technology, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hBuzzEntertainmentRecyclerView = view.findViewById(R.id.buzzTechnologyRecyclerView);
        hBuzzTechnologyWebView = view.findViewById(R.id.buzzTechnologyWebView);
        NewsApiClient newsApiClient = new NewsApiClient("187bbe8bdd6a41ca92244c9b0042425d");
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .language("en")
                        .country("in")
                        .category("technology")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        BuzzAdapter buzzAdapter = new BuzzAdapter(getContext(), response.getArticles(), TechnologyFragment.this);
                        hBuzzTechnologyArticleResponse = response;
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                        hBuzzEntertainmentRecyclerView.setLayoutManager(linearLayoutManager);
                        hBuzzEntertainmentRecyclerView.setAdapter(buzzAdapter);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );
    }

    @Override
    public void onClick(int position) {
        hBuzzTechnologyWebView.setVisibility(View.VISIBLE);
        hBuzzTechnologyWebView.loadUrl(hBuzzTechnologyArticleResponse.getArticles().get(position).getUrl());
    }

}