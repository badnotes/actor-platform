package im.actor.core.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.runtime.bser.*;
import im.actor.runtime.collections.*;
import static im.actor.runtime.bser.Utils.*;
import im.actor.core.network.parser.*;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import com.google.j2objc.annotations.ObjectiveCName;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import im.actor.core.api.*;

public class RequestRawRequest extends Request<ResponseRawRequest> {

    public static final int HEADER = 0xa09;
    public static RequestRawRequest fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestRawRequest(), data);
    }

    private String service;
    private String method;
    private ApiRawValue params;

    public RequestRawRequest(@NotNull String service, @NotNull String method, @Nullable ApiRawValue params) {
        this.service = service;
        this.method = method;
        this.params = params;
    }

    public RequestRawRequest() {

    }

    @NotNull
    public String getService() {
        return this.service;
    }

    @NotNull
    public String getMethod() {
        return this.method;
    }

    @Nullable
    public ApiRawValue getParams() {
        return this.params;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.service = values.getString(1);
        this.method = values.getString(2);
        if (values.optBytes(3) != null) {
            this.params = ApiRawValue.fromBytes(values.getBytes(3));
        }
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.service == null) {
            throw new IOException();
        }
        writer.writeString(1, this.service);
        if (this.method == null) {
            throw new IOException();
        }
        writer.writeString(2, this.method);
        if (this.params != null) {
            writer.writeBytes(3, this.params.buildContainer());
        }
    }

    @Override
    public String toString() {
        String res = "rpc RawRequest{";
        res += "service=" + this.service;
        res += ", method=" + this.method;
        res += ", params=" + this.params;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}