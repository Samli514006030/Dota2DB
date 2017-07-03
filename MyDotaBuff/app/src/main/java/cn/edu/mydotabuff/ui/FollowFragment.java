package cn.edu.mydotabuff.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.mydotabuff.R;
import cn.edu.mydotabuff.base.BaseFragment;
import cn.edu.mydotabuff.base.BaseListAdapter;
import cn.edu.mydotabuff.base.BaseListHolder;
import cn.edu.mydotabuff.common.ClickTag;
import cn.edu.mydotabuff.model.Match;
import cn.edu.mydotabuff.ui.presenter.IFollowFragmentPresenter;
import cn.edu.mydotabuff.ui.presenter.impl.FollowFragmentPresenterImpl;
import cn.edu.mydotabuff.ui.view.IFollowFragmentView;
import cn.edu.mydotabuff.view.SwipeRefreshRecycleView;

/**
 * Created by nevermore on 2017/6/28 0028.
 */

public class FollowFragment extends BaseFragment<IFollowFragmentPresenter> implements IFollowFragmentView {
    @BindView(R.id.rv_list)
    SwipeRefreshRecycleView mRvList;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.fl_success)
    FrameLayout mFlSuccess;
    private BaseListAdapter<Match> mAdapter;
    private List<Match> mMatches = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_follow_base, container, false);
        ButterKnife.bind(this, view);

        init();
        return view;
    }

    private void init() {
        setSuccessView(mFlSuccess);
        mRvList.setAdapter(mAdapter = new BaseListAdapter<Match>(mMatches, R.layout.fragment_follow_item, ClickTag.CLICK_TO_DETAIL) {
            @Override
            public void getView(BaseListHolder holder, Match bean, int pos) {
                //holder.setImageURI(R.id.sdv_user_icon,mat);
                //holder.setText(R.id.tv_player_name,);
                //holder.setText(bean.radiant_win ? "" : "");
            }
        });
        mPresenter = new FollowFragmentPresenterImpl(this);
    }
}