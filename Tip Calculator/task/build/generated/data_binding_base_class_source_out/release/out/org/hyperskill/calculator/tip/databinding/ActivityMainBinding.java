// Generated by view binder compiler. Do not edit!
package org.hyperskill.calculator.tip.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import org.hyperskill.calculator.tip.R;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView billValueTv;

  @NonNull
  public final EditText editText;

  @NonNull
  public final SeekBar seekBar;

  @NonNull
  public final TextView tipAmountTv;

  @NonNull
  public final TextView tipPercentTv;

  private ActivityMainBinding(@NonNull LinearLayout rootView, @NonNull TextView billValueTv,
      @NonNull EditText editText, @NonNull SeekBar seekBar, @NonNull TextView tipAmountTv,
      @NonNull TextView tipPercentTv) {
    this.rootView = rootView;
    this.billValueTv = billValueTv;
    this.editText = editText;
    this.seekBar = seekBar;
    this.tipAmountTv = tipAmountTv;
    this.tipPercentTv = tipPercentTv;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bill_value_tv;
      TextView billValueTv = ViewBindings.findChildViewById(rootView, id);
      if (billValueTv == null) {
        break missingId;
      }

      id = R.id.edit_text;
      EditText editText = ViewBindings.findChildViewById(rootView, id);
      if (editText == null) {
        break missingId;
      }

      id = R.id.seek_bar;
      SeekBar seekBar = ViewBindings.findChildViewById(rootView, id);
      if (seekBar == null) {
        break missingId;
      }

      id = R.id.tip_amount_tv;
      TextView tipAmountTv = ViewBindings.findChildViewById(rootView, id);
      if (tipAmountTv == null) {
        break missingId;
      }

      id = R.id.tip_percent_tv;
      TextView tipPercentTv = ViewBindings.findChildViewById(rootView, id);
      if (tipPercentTv == null) {
        break missingId;
      }

      return new ActivityMainBinding((LinearLayout) rootView, billValueTv, editText, seekBar,
          tipAmountTv, tipPercentTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
