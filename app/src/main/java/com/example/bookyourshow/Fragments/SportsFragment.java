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

public class SportsFragment extends Fragment implements OnItemClickListener {

    private RecyclerView hBuzzSportsRecyclerView;
    private ArticleResponse hBuzzSportsArticleResponse;
    private WebView hBuzzSportsWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sports, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hBuzzSportsRecyclerView = view.findViewById(R.id.buzzSportsRecyclerView);
        hBuzzSportsWebView = view.findViewById(R.id.buzzSportsWebView);
        NewsApiClient newsApiClient = new NewsApiClient("187bbe8bdd6a41ca92244c9b0042425d");
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .language("en")
                        .country("in")
                        .category("sports")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        BuzzAdapter buzzAdapter = new BuzzAdapter(getContext(), response.getArticles(), SportsFragment.this);
                        hBuzzSportsArticleResponse = response;
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                        hBuzzSportsRecyclerView.setLayoutManager(linearLayoutManager);
                        hBuzzSportsRecyclerView.setAdapter(buzzAdapter);
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
        hBuzzSportsWebView.setVisibility(View.VISIBLE);
        hBuzzSportsWebView.loadUrl(hBuzzSportsArticleResponse.getArticles().get(position).getUrl());
    }

}