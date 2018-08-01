package com.nloops.lossless.cards;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.nloops.lossless.R;
import com.nloops.lossless.cards.CardsAdapter.CardsViewHolder;
import java.util.ArrayList;

public class CardsAdapter extends RecyclerView.Adapter<CardsViewHolder> {


  /*this array list will holds the models that needs to display*/
  private ArrayList<CardModel> mModelsArrayList;

  public CardsAdapter(ArrayList<CardModel> models) {
    this.mModelsArrayList = models;
  }

  @NonNull
  @Override
  public CardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    int layoutID = R.layout.card_list_item;
    View returnedView = LayoutInflater.from(parent.getContext()).inflate(
        layoutID, parent, false);
    return new CardsViewHolder(returnedView);
  }

  @Override
  public void onBindViewHolder(@NonNull CardsViewHolder holder, int position) {
    /*Get the Current Model upon position*/
    CardModel currentModel = mModelsArrayList.get(position);
    /*Set Current View elements values*/
    holder.mCardImageView.setImageResource(currentModel.getCardImageID());
    holder.mCardName.setText(currentModel.getCardName());
    holder.mCardStatus.setText(currentModel.getCardStatus());

  }

  @Override
  public int getItemCount() {
    return mModelsArrayList != null ? mModelsArrayList.size() : 0;
  }

  /**
   * This class will holds the Views for each Element in {@link #mModelsArrayList}
   */
  class CardsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_card_item)
    ImageView mCardImageView;
    @BindView(R.id.tv_card_name)
    TextView mCardName;
    @BindView(R.id.tv_card_status)
    TextView mCardStatus;

    public CardsViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }

}