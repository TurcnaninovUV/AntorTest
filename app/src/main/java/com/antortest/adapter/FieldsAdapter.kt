package com.antortest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.antortest.databinding.CardBinding
import com.antortest.dto.Fields


class FieldsAdapter :
    ListAdapter<Fields, FieldsViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FieldsViewHolder {
        val binding = CardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FieldsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FieldsViewHolder, position: Int) {
        val field = getItem(position)
        holder.bind(field)
    }
}


class FieldsViewHolder(
    private val binding: CardBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(fields: Fields) {
        binding.apply {
            if (fields.showInt) textInt.visibility = View.VISIBLE
            else textInt.visibility = View.GONE
            if (fields.showDouble) textDouble.visibility = View.VISIBLE
            else textDouble.visibility = View.GONE
            if (fields.showString) textString.visibility = View.VISIBLE
            else textString.visibility = View.GONE
            textDouble.text = fields.fieldDouble.toString()
            textInt.text = fields.fieldInt.toString()
            textString.text = fields.fieldString
        }
    }
}

object DiffCallback : DiffUtil.ItemCallback<Fields>() {
    override fun areItemsTheSame(oldItem: Fields, newItem: Fields): Boolean {
        return oldItem.fieldInt == newItem.fieldInt
    }

    override fun areContentsTheSame(oldItem: Fields, newItem: Fields): Boolean {
        return oldItem == newItem
    }
}