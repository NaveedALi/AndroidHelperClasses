package com.naveed.samples;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChoiceDialog extends BaseDialogFragment {

    private String message = null;
    private String title = null;
    private DialogType alertType = DialogType.ANY;
    private DialogActionListener listener;

    private String startBtnText;
    private String endBtnText;
    private int startBtnColor = 0;
    private int endBtnColor = 0;
    private boolean isCancelable = false;

    @BindView(R.id.tv_title)
    protected TextView tvTitle;

    @BindView(R.id.tv_message)
    protected TextView tvMessage;


    @BindView(R.id.btn_start)
    protected Button btnStart;

    @BindView(R.id.btn_end)
    protected Button btnEnd;

    @BindView(R.id.view_space)
    protected View viewSpace;

    public ChoiceDialog() {
    }

    @SuppressLint("ValidFragment")
    private ChoiceDialog(final Builder builder) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", builder);
        setArguments(bundle);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Builder builder = getArguments().getParcelable("params");
            title = builder.title;
            message = builder.message;
            startBtnText = builder.startBtnText;
            endBtnText = builder.endBtnText;
            startBtnColor = builder.startBtnColor;
            endBtnColor = builder.endBtnColor;
            isCancelable = builder.isCancelable;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_choice_dialog, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);


        if (title == null || title.isEmpty()) {
            tvTitle.setVisibility(View.GONE);
        } else tvTitle.setText(title);


        if (message == null || message.isEmpty()) {
            tvMessage.setVisibility(View.GONE);
        } else tvMessage.setText(message);


        if (startBtnText != null)
            btnStart.setText(startBtnText);
        else {
            viewSpace.setVisibility(View.GONE);
            btnStart.setVisibility(View.GONE);
        }

        if (endBtnText != null)
            btnEnd.setText(endBtnText);
        else {
            btnEnd.setVisibility(View.GONE);
            viewSpace.setVisibility(View.GONE);
        }


        if (startBtnColor != 0)
            btnStart.setBackgroundColor(startBtnColor);
        if (endBtnColor != 0)
            btnEnd.setBackgroundColor(endBtnColor);

    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().setCancelable(isCancelable);
    }

    @OnClick(R.id.btn_start)
    void onClickedStartBtn() {
        if (listener != null)
            listener.onSelected(this, alertType, DialogAction.ACTION_POSITIVE);
    }


    @OnClick(R.id.btn_end)
    void onClickedEndBtn() {
        if (listener != null)
            listener.onSelected(this, alertType, DialogAction.ACTION_NEGATIVE);
    }


    public DialogActionListener getListener() {
        return listener;
    }

    public void setListener(DialogActionListener listener) {
        this.listener = listener;
    }

    public static class Builder implements Parcelable {

        private String message = null;
        private String title = null;
        private String startBtnText = null;
        private String endBtnText = null;
        private int startBtnColor = 0;
        private int endBtnColor = 0;
        private boolean isCancelable = false;

        public String getMessage() {
            return message;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getStartBtnText() {
            return startBtnText;
        }

        public Builder setStartBtnText(String startBtnText) {
            this.startBtnText = startBtnText;
            return this;
        }

        public String getEndBtnText() {
            return endBtnText;
        }

        public Builder setEndBtnText(String endBtnText) {
            this.endBtnText = endBtnText;
            return this;
        }

        public int getStartBtnColor() {
            return startBtnColor;
        }

        public Builder setStartBtnColor(int startBtnColor) {
            this.startBtnColor = startBtnColor;
            return this;
        }

        public int getEndBtnColor() {
            return endBtnColor;
        }

        public Builder setEndBtnColor(int endBtnColor) {
            this.endBtnColor = endBtnColor;
            return this;
        }

        public Builder setCancelable(Boolean cancelable) {
            this.isCancelable = cancelable;
            return this;
        }

        public ChoiceDialog create() {
            return new ChoiceDialog(this);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.message);
            dest.writeString(this.title);
            dest.writeString(this.startBtnText);
            dest.writeString(this.endBtnText);
            dest.writeInt(this.startBtnColor);
            dest.writeInt(this.endBtnColor);
        }

        public Builder() {
            
        }

        protected Builder(Parcel in) {
            this.message = in.readString();
            this.title = in.readString();
            this.startBtnText = in.readString();
            this.endBtnText = in.readString();
            this.startBtnColor = in.readInt();
            this.endBtnColor = in.readInt();
        }

        public final Parcelable.Creator<Builder> CREATOR = new Parcelable.Creator<Builder>() {
            @Override
            public Builder createFromParcel(Parcel source) {
                return new Builder(source);
            }

            @Override
            public Builder[] newArray(int size) {
                return new Builder[size];
            }
        };
    }

}
