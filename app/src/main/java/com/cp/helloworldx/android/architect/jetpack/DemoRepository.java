package com.cp.helloworldx.android.architect.jetpack;

public class DemoRepository {
//    public LiveData<ProdVOSubmit> getProdDetail(String prodId) {
//        final MutableLiveData<ProdVOSubmit> data = new MutableLiveData<>();
//        HttpHelper.getInstance().getProdService().loadProdDetail(UrlMap.getUrlWithToken(UrlMap.getUrl(UrlMap.PRO_GET_BY_ID, prodId)))
//                .compose(RxSchedulersHelper.<HttpResponse<ProdVOSubmit>>defaultSchedulers())
//                .subscribe(new HttpResponseObserver<ProdVOSubmit>() {
//
//                    @Override
//                    public void onSuccess(ProdVOSubmit prodVOSubmit) {
//                        data.setValue(prodVOSubmit);
//                    }
//
//                    @Override
//                    public void onError(Throwable e, int code) {
//                        ToastErrorMsg(e);
//                        data.setValue(null);
//                    }
//                });
//        return data;
//    }
}
