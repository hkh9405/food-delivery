
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import OrderInfoView from "./components/OrderInfoView"
import OrderInfoViewDetail from "./components/OrderInfoViewDetail"
import OrderManageManager from "./components/listers/OrderManageCards"
import OrderManageDetail from "./components/listers/OrderManageDetail"

import OrderDtlView from "./components/OrderDtlView"
import OrderDtlViewDetail from "./components/OrderDtlViewDetail"
import PayManager from "./components/listers/PayCards"
import PayDetail from "./components/listers/PayDetail"


import DeliveryManager from "./components/listers/DeliveryCards"
import DeliveryDetail from "./components/listers/DeliveryDetail"
import CmpltTrtManager from "./components/listers/CmpltTrtCards"
import CmpltTrtDetail from "./components/listers/CmpltTrtDetail"

import DeliveryInfoView from "./components/DeliveryInfoView"
import DeliveryInfoViewDetail from "./components/DeliveryInfoViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/orderInfos',
                name: 'OrderInfoView',
                component: OrderInfoView
            },
            {
                path: '/orderInfos/:id',
                name: 'OrderInfoViewDetail',
                component: OrderInfoViewDetail
            },
            {
                path: '/orderManages',
                name: 'OrderManageManager',
                component: OrderManageManager
            },
            {
                path: '/orderManages/:id',
                name: 'OrderManageDetail',
                component: OrderManageDetail
            },

            {
                path: '/orderDtls',
                name: 'OrderDtlView',
                component: OrderDtlView
            },
            {
                path: '/orderDtls/:id',
                name: 'OrderDtlViewDetail',
                component: OrderDtlViewDetail
            },
            {
                path: '/pays',
                name: 'PayManager',
                component: PayManager
            },
            {
                path: '/pays/:id',
                name: 'PayDetail',
                component: PayDetail
            },


            {
                path: '/deliveries',
                name: 'DeliveryManager',
                component: DeliveryManager
            },
            {
                path: '/deliveries/:id',
                name: 'DeliveryDetail',
                component: DeliveryDetail
            },
            {
                path: '/cmpltTrts',
                name: 'CmpltTrtManager',
                component: CmpltTrtManager
            },
            {
                path: '/cmpltTrts/:id',
                name: 'CmpltTrtDetail',
                component: CmpltTrtDetail
            },

            {
                path: '/deliveryInfos',
                name: 'DeliveryInfoView',
                component: DeliveryInfoView
            },
            {
                path: '/deliveryInfos/:id',
                name: 'DeliveryInfoViewDetail',
                component: DeliveryInfoViewDetail
            },


    ]
})
