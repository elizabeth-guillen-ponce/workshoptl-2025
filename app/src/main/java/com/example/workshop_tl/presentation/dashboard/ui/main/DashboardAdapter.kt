package com.example.workshop_tl.presentation.dashboard.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workshop_tl.databinding.BalanceItemBinding
import com.example.workshop_tl.databinding.GoldCardItemBinding
import com.example.workshop_tl.databinding.HeaderItemBinding
import com.example.workshop_tl.databinding.PromotionCardItemBinding
import com.example.workshop_tl.databinding.SilverCardItemBinding

class DashboardAdapter(
    private val items: List<DashboardItem>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        //Add new item
    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is DashboardItem.HeaderItem -> DashboardItem.ItemType.HEADER.value
            is DashboardItem.GoldCard -> DashboardItem.ItemType.GOLD_CARD.value
            is DashboardItem.PromotionCard -> DashboardItem.ItemType.PROMOTION_CARD.value
            is DashboardItem.SilverCard -> DashboardItem.ItemType.SILVER_CARD.value
            is DashboardItem.Balance -> DashboardItem.ItemType.BALANCE.value
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            DashboardItem.ItemType.HEADER.value -> HeaderViewHolder(
                HeaderItemBinding.inflate(
                    inflater,
                    parent,
                    false
                ),
                parent.context
            )

            DashboardItem.ItemType.GOLD_CARD.value -> GoldCardViewHolder(
                GoldCardItemBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )

            DashboardItem.ItemType.PROMOTION_CARD.value -> PromotionViewHolder(
                PromotionCardItemBinding.inflate(
                    inflater, parent, false
                )
            )

            DashboardItem.ItemType.SILVER_CARD.value -> SilverCardViewHolder(
                SilverCardItemBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )

            DashboardItem.ItemType.BALANCE.value -> BalanceViewHolder(
                BalanceItemBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        when (val item = items[position]) {
            is DashboardItem.HeaderItem -> (holder as HeaderViewHolder).bind(item)
            is DashboardItem.GoldCard -> (holder as GoldCardViewHolder).bind(item)
            is DashboardItem.PromotionCard -> (holder as PromotionViewHolder).bind(item)
            is DashboardItem.SilverCard -> (holder as SilverCardViewHolder).bind(item)
            is DashboardItem.Balance -> (holder as BalanceViewHolder).bind(item)
            // Add more types as needed
        }
    }

    override fun getItemCount() = items.size
}