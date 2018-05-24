package Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/**
 * Created by maxhe on 24-5-2018.
 */

public class User implements Parcelable {
    GoogleSignInAccount account;

    public User(GoogleSignInAccount account){
        this.account = account;
    }

    protected User(Parcel in) {
        account = in.readParcelable(GoogleSignInAccount.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(account, flags);
    }
}
