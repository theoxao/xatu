'use strict';
if (!String.prototype.trim) {
    String.prototype.trim = function () {
        return this.replace(/^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g, '');
    };
}

function trim(raw) {
    return (raw === undefined || raw === null) ? raw : raw.trim();
}

function isEmpty(data) {
    return data === null || data === undefined || data === '';
}

function _evalInContext(expression) {
    return eval(expression);
}

function renderTemplate(tpl, params) {
    return tpl.replace(/{([a-zA-Z0-9\-_]+|@eval:[a-zA-Z0-9\-_()+*%/.\s]+)}/g, function (i, j, k) {
        console.log(j.indexOf('@eval:'));
        if (j.indexOf('@eval:') === 0) {
            // eval
            return _evalInContext.call(params, j.substring(6));
        }
        return params[j];
    });
}

/**
 * color rgb to hex
 * @param r red channel
 * @param g green channel
 * @param b blue channel
 * @returns {String} hex format
 */
function rgbToHex(r, g, b) {
    r = Number(r).toString(16);
    if (r.length < 2) {
        r = '0' + r;
    }
    g = Number(g).toString(16);
    if (g.length < 2) {
        g = '0' + g;
    }
    b = Number(b).toString(16);
    if (b.length < 2) {
        b = '0' + b;
    }
    return r + g + b;
}

const BYTES_UNIT = 1024;
const BYTES_SIZES = ['Bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];

/**
 * format bytes {@link https://stackoverflow.com/questions/15900485/correct-way-to-convert-size-in-bytes-to-kb-mb-gb-in-javascript}
 * @param bytes byte number
 * @param decimals precision
 * @returns {*}
 */
function formatBytes(bytes, decimals = 2) {
    if (bytes === 0) return '0 ' + BYTES_SIZES[0];
    var i = Math.floor(Math.log(bytes) / Math.log(BYTES_UNIT));
    return parseFloat((bytes / Math.pow(BYTES_UNIT, i)).toFixed(decimals)) + ' ' + BYTES_SIZES[i];
}

/**
 * 获得两数之间的随机数
 * @param min include
 * @param max exclude
 * @returns {*}
 */
function randomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min)) + min;
}

/**
 * 工具条随滚动而浮动
 * @param toolbar
 */
function floatToolbar(toolbar) {
    const top = toolbar.offset().top;
    const parent = toolbar.parent();
    parent.css('height', parent.height());
    $(window).scroll(function () {
        if ($(window).scrollTop() > top) {
            if (!toolbar.is('.fixed')) {
                toolbar.addClass('fixed');
                toolbar.css('width', $('#data-table').innerWidth() + 'px');
            }
        } else {
            if (toolbar.is('.fixed')) {
                toolbar.removeClass('fixed');
                toolbar.css('width', 'auto');
            }
        }
    });
}

const Alert = (function () {
    const TPL = `
<div class="alert alert-dismissable">
    <button type="button" class="close" aria-hidden="true">&times;</button>
</div>
    `;
    const toastOffset = 8;
    const toastLife = 2000;

    function clearToast(toast) {
        toast.removeClass('in');
        setTimeout(() => {
            const height = toast.outerHeight();
            toast.nextAll().each(function () {
                $(this).css('top', $(this).position().top - height - toastOffset);
            });
            toast.remove();
        }, 150);
    }

    function success(msg) {
        show('success', msg);
    }

    function info(msg) {
        show('info', msg);
    }

    function warn(msg) {
        show('warning', msg);
    }

    function error(msg) {
        show('danger', msg);
    }

    function show(type, msg) {
        if (msg === null || msg === undefined || msg.length === 0) {
            return;
        }
        const toast = $(TPL).addClass('alert-' + type).append(msg);
        let interval = null;
        toast.on('click', '.close', function () {
            if (!toast.is('.in')) {
                return;
            }
            window.clearTimeout(interval);
            clearToast(toast);
        });
        let lastToast = $('body>.alert:last');
        if (lastToast.length > 0) {
            toast.css('top', lastToast.position().top + lastToast.outerHeight() + toastOffset);
        }
        toast.appendTo('body');
        setTimeout(() => {
            toast.addClass('in');
            interval = window.setTimeout(() => clearToast(toast), toastLife);
        }, 10);
    }

    return {success, info, warn, error};
})();
const MODAL_ALERT_TPL = `
<div class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"></h4>
            </div>
            <div class="modal-body">
                <div class="alert-message"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
            </div>
        </div>
    </div>
</div>
`;
const ModalAlert = (function () {
    let primaryBtn;
    let contentContainer;

    function create() {
        const modal = $(MODAL_ALERT_TPL).appendTo('body');
        modal.find('.modal-title').text('提醒');
        primaryBtn = modal.find('.modal-footer>button');
        contentContainer = modal.find('.alert-message');
        modal.on('hidden.bs.modal', function () {
            modal.remove();
        })
        return modal;
    }

    function show(content, callback) {
        const modal = create();
        contentContainer.html(content);
        primaryBtn.one('click', () => {
            modal.modal('hide');
            // modal.remove();
            if (callback) {
                callback(modal);
            }
        });
        modal.modal({backdrop: 'static'});
    }

    function info(content, callback) {
        show(content, callback);
    }

    function success(content, callback) {
        show(content, callback);
    }

    function error(content, callback) {
        show(content, callback);
    }

    function warn(content, callback) {
        show(content, callback);
    }

    return {info, success, error, warn};
}());
const Confirm = (function () {
    let modal = null;
    let primaryBtn;
    let contentContainer;

    function create() {
        modal = $(PANEL_TPL).appendTo('body');
        modal.find('.modal-title').text('确认');
        primaryBtn = modal.find('.modal-footer>button.btn-primary').text('确定');
        contentContainer = modal.find('.modal-body');
        modal.on('hidden.bs.modal', function () {
            primaryBtn.off('click');
        });
        modal.showProgress = function () {
            btnWaiting(primaryBtn);
            // modal.find('.modal-progress').addClass('active');
            return modal;
        };
        modal.hideProgress = function () {
            btnFinished(primaryBtn);
            // modal.find('.modal-progress').removeClass('active');
            return modal;
        };
        return modal;
    }

    function show(content, callback) {
        if (modal === null) {
            create();
        }
        contentContainer.html(content);
        primaryBtn.on('click', () => {
            dismiss();
            callback(modal);
        });
        modal.modal({backdrop: 'static'});
    }

    function dismiss() {
        modal.modal('hide');
    }

    function hide() {
        dismiss();
    }

    function wait() {
        modal.showProgress();
    }

    function finish() {
        modal.hideProgress();
    }

    return {show, hide, dismiss, wait, finish};
})();

function startPageProgress() {
    NProgress.start();
}

function finishPageProgress() {
    NProgress.done();
}

/**
 * 表格checkbox绑定选择全部的事件
 * @param root checkbox所在的顶级元素
 */
function bindCheckAll(root) {
    root.find('[data-role="check-all"]').click(function () {
        root.find('[data-role="check"]').prop('checked', $(this).prop('checked'));
    });
}

function bindTableCollapse(root) {
    root.on('click', '[data-role="collapse"]', function () {
        $(this).toggleClass('collapsed');
        $(this).closest('tr').next('.table-expand').toggleClass('collapsed');
    });
    root.find('[data-role="collapse-all"]').click(function () {
        const collapsed = $(this).is('.collapsed');
        if (collapsed) {
            $(this).removeClass('collapsed');
            root.find('tr>td>[data-role="collapse"]').removeClass('collapsed');
            root.find('tr.table-expand').removeClass('collapsed');
        } else {
            $(this).addClass('collapsed');
            root.find('tr>td>[data-role="collapse"]').addClass('collapsed');
            root.find('tr.table-expand').addClass('collapsed');
        }
    });
}

/**
 * 表格选中的checkbox的值
 * @param root checkbox所在的顶级元素
 * @returns {*} ID列表
 */
function getTableChecked(root) {
    const result = [];
    root.find('input[data-role="check"]:checked').each(function () {
        result.push($(this).attr('value'));
    });
    return result;
}

/**
 * 创建加载动画条
 * @param container 放置加载条的容器
 * @param colspan td跨越列数
 */
function renderLoadBar(container, colspan) {
    container.html(`<td colspan="${colspan}" class="table-loading"><img src="${static_base}/images/ajax_bar.gif"></td>`);
}

function renderModalLoadBar(modal) {
    modal.find('.modal-body').html(`<div class="table-loading"><img src="${static_base}/images/ajax_bar.gif"></div>`);
}

/**
 * 通用的加载表格数据方法
 * @param url 请求url
 * @param page 当前页码, 可省略，默认1
 * @param callback 请求完成后的回调方法
 * @param pageSize 大小
 */
function loadTable(url, page = 0, callback = $.noop, pageSize = 20) {
    if (typeof page === 'function') {
        callback = page;
        page = 0;
    }
    const dataTable = $('#data-table');
    const panelBody = dataTable.closest('.panel-body');
    const pagePanel = panelBody.find('.page-panel');
    if (page === 0) {
        const activePage = pagePanel.find('.pagination>.paginate_button.active');
        if (activePage.length > 0) {
            page = activePage.text();
        } else {
            page = 1;
        }
    }
    const orderBy = readOrderBy(dataTable);
    const size = pagePanel.find('.pagination select:not(#pageSelector)').val() || pagePanel.attr('data-size') || pageSize;
    renderLoadBar(dataTable.find('>tbody'), dataTable.find('>thead>tr>th').length);
    const searchForm = panelBody.find('.search-form');
    const data = searchForm.length === 0 ? {} : searchForm.serialize();
    $.ajax({
        url: `${url}?page=${page}&size=${size}&orderBy=${orderBy}`,// TODO:支持url带参数
        data: data,
        dataType: 'html',
        type: 'GET',
        success: (result) => {
            const tbody = dataTable.find('>tbody').replaceWith(result).end().find('>tbody');
            const paginationStr = tbody.attr('data-pagination');
            if (paginationStr !== undefined && paginationStr !== '') {
                const pagination = JSON.parse(tbody.attr('data-pagination'));
                createPagination(pagePanel, pagination, (page) => loadTable(url, page, callback));
            }
            tbody.find('[data-toggle="tooltip"]').tooltip();

            // 支持快捷过滤
            dataTable.find('>thead th[data-filter]').each(function () {
                const cellIndex = $(this)[0].cellIndex;
                const name = $(this).attr('data-filter');
                tbody.find('tr:not(.table-expand)>td:nth-child(' + (cellIndex + 1) + ')').each(function () {
                    const td = $(this);
                    if (td.attr('data-value') === undefined) {
                        if (td.text() === '') {
                            return;
                        }
                        td.attr('data-value', td.text());
                    }
                    td.append($('<span class="filter-apply-btn fa fa-filter"></span>').click(function () {
                        searchForm.find('[name="' + name + '"]').val(td.attr('data-value')).trigger('submit');
                    }).tooltip({title: '点击以此过滤'}));
                });
            });

            callback(tbody);
        }
    })
}

function readOrderBy(table) {
    const orderBy = [];
    table.find('th[data-sortable="true"]').each(function () {
        const order = $(this).attr('data-order');
        if (order === 'asc' || order === 'desc') {
            orderBy.push($(this).attr('data-field') + ' ' + order);
        }
    });
    return orderBy.length > 0 ? orderBy.join(',') : '';
}

/**
 * 最大分页按钮数
 * @type {number}
 */
const MAX_PAGE_BTN = 7;

/**
 * 创建分页面板
 * @param container 分页面板所在容器
 * @param pagination 分页数据
 * @param loadData 加载数据的方法
 */
function createPagination(container, pagination, loadData) {
    const statusEl = container.find('.page-status');
    statusEl.text(`当前${pagination.page}/${pagination.totalPages}，共${pagination.totalCount}条记录`);
    const btnContainer = container.find('.pagination');
    btnContainer.empty();
    if (pagination.totalPages === 0) {
        return;
    }

    const firstBtn = $('<li class="paginate_button" tabindex="0"><a href="#">首页</a></li>').appendTo(btnContainer);
    const prevBtn = $('<li class="paginate_button" tabindex="0"><a href="#">上一页</a></li>').appendTo(btnContainer);
    if (pagination.page === 1) {
        firstBtn.addClass('disabled');
        prevBtn.addClass('disabled');
    } else {
        firstBtn.find('a').click(() => loadData(1));
        prevBtn.find('a').click(() => loadData(pagination.page - 1));
    }
    let first;
    if (pagination.totalPages - pagination.page < 3) {
        first = pagination.totalPages - MAX_PAGE_BTN + 1;
    } else {
        first = Math.ceil(pagination.page - MAX_PAGE_BTN / 2);
    }
    first = Math.max(first, 1);
    const btnCount = Math.min(pagination.totalPages, MAX_PAGE_BTN);
    for (let i = 0; i < btnCount; i++) {
        const page = first + i;
        if (page > pagination.totalPages) {
            break;
        }
        const btn = $('<li class="paginate_button " tabindex="0"><a href="#"></a></li>');
        btn.find('a').text(page);
        if (page === pagination.page) {
            btn.addClass('active');
        } else {
            btn.find('a').click(() => {
                loadData(page)
            });
        }
        btnContainer.append(btn);
    }
    const nextBtn = $('<li class="paginate_button" tabindex="0"><a href="#">下一页</a></li>').appendTo(btnContainer);
    const lastBtn = $('<li class="paginate_button" tabindex="0"><a href="#">末页</a></li>').appendTo(btnContainer);


    const pageLocationInput = $('<li class="paginate_button"><select id="pageSelector" class="form-control" style="display:inline-block;width:80px;margin-left:-1px;padding:6px;"></select></li>').appendTo(btnContainer).find('#pageSelector');

    for (let i = 1; i <= pagination.totalPages; i++) {
        pageLocationInput.append(`<option value="${i}">第${i}页</option>`)
    }
    pageLocationInput.val(pagination.page);
    pageLocationInput.change(() => {
        let location = pageLocationInput.val();
        loadData(location)
    });


    const pageSizeInput = $('<li class="paginate_button" style="margin-left:-1px;"><select class="form-control" style="display:inline-block;width:60px;margin-left:-1px;padding:6px;"></select></li>').appendTo(btnContainer).find('select');
    [10, 20, 50, 100].forEach((i) => pageSizeInput.append(`<option value="${i}">${i}</option>`));
    pageSizeInput.val(pagination.size);
    pageSizeInput.change(() => loadData(pagination.page));
    if (pagination.page === pagination.totalPages) {
        nextBtn.addClass('disabled');
        lastBtn.addClass('disabled');
    } else {
        nextBtn.find('a').click(() => loadData(pagination.page + 1));
        lastBtn.find('a').click(() => loadData(pagination.totalPages));
    }
    const showSizeInput = container.attr('data-show-size') !== '0';
    if (!showSizeInput) {
        pageSizeInput.parent().hide();
    }
}

// function createCascadeSelect(data, containers, values, parentGeneric = false) {
//     let items = null;
//     for (let i = 0; i < containers.length; i++) {
//         if (items === null) {
//             items = data;
//         } else {
//             items = data.cascades;
//         }
//         const container = containers[i].empty();
//         const firstOption = $('<option value="">不限</option>');
//         container.append(firstOption);
//         if (parentGeneric) {
//             container.prop('disabled', true);
//         } else {
//             container.prop('disabled', false);
//             items.map((item) => {
//                 container.append(`<option value="${item.value}">${item.text}</option>`);
//             });
//             if (containers.length > 1) {
//                 container.unbind('change').bind('change', {items: items}, function (event) {
//                     const selected = event.data.items.find(element => element.value === $(this).val());
//                     createCascadeSelect(selected === undefined ? null : selected.cascades, containers.slice(i + 1), undefined, selected === undefined);
//                 });
//             }
//         }
//         if (values === undefined || values[i] === '') {
//             firstOption.prop('selected', true);
//             parentGeneric = true;
//             createCascadeSelect(null, containers.slice(1), undefined, true);
//         } else {
//             createCascadeSelect(data.find((item)=>item.value === values[0]), containers.slice(1), values.slice(1), false);
//         }
//     }
// }
/**
 * 创建级联select表单
 * @param data 数据
 * @param containers
 * @param values
 * @param parentGeneric
 */
function createCascadeSelect(data, containers, values, parentGeneric = false) {
    if (containers.length === 0) {
        return;
    }
    if (data === null) {
        data = [];
    }
    let items = null;
    if (items === null) {
        items = data;
    } else {
        items = data.cascades;
    }
    const container = containers[0].empty();
    const firstOption = $('<option value="">不限</option>');
    const value = (values === undefined || values.length === 0) ? '' : values[0];
    if (value === '') {
        firstOption.prop('selected', true);
    }
    container.append(firstOption);
    if (parentGeneric) {
        container.prop('disabled', true);
    } else {
        container.prop('disabled', false);
        items.map((item) => {
            container.append(`<option value="${item.optionValue}" ${item.optionValue === value ? 'selected' : ''}>${item.optionText}</option>`);
        });
        if (containers.length > 1) {
            container.unbind('change').bind('change', function (event) {
                const selected = items.find(element => element.optionValue === $(this).val());
                createCascadeSelect(selected === undefined ? data[0].cascades : selected.cascades, containers.slice(1), undefined, selected === undefined);
            });
        }
    }
    if (containers.length === 1) {
        return;
    }
    if (value === '') {
        createCascadeSelect(data.length === 0 ? null : data[0].cascades, containers.slice(1), undefined, true);
    } else {
        createCascadeSelect(data.find((item) => item.optionValue === value).cascades, containers.slice(1), values.slice(1), false);
    }
}

function renderSelectOptions(select, optionData) {
    for (let i = 0; i < optionData.length; i++) {
        select.append(`<option value="${optionData[i].optionValue}" data-extra="${optionData[i].optionExtra}">${optionData[i].optionText}</option>`);
    }
}

const PANEL_TPL = `
<div class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title"></h4>
            </div>
            <div class="modal-progress"><div></div></div>
            <div class="modal-body">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary"><i class="fa fa-circle-o-notch fa-spin fa-fw margin-bottom"></i>确定</button>
            </div>
        </div>
    </div>
</div>
`;

function createEmptyModal(title, okCallback) {
    const modal = $(PANEL_TPL).appendTo('body');
    modal.find('.modal-title').text(title);
    const primaryBtn = modal.find('.modal-footer>button.btn-primary').click(function () {
        if (modal.find('form').length === 0 && !modal.is('[data-no-form]')) {
            modal.modal('hide');
            return;
        }
        if (primaryBtn.is('.waiting') || primaryBtn.is('.disabled')) {
            return;
        }
        okCallback(modal);
    });
    modal.primaryBtn = primaryBtn;
    modal.on('submit', 'form', function () {
        primaryBtn.trigger('click');
        return false;
    });
    modal.wait = modal.showProgress = function () {
        btnWaiting(primaryBtn);
        // modal.find('.modal-progress').addClass('active');
        return modal;
    };
    modal.finish = modal.hideProgress = function () {
        btnFinished(primaryBtn);
        // modal.find('.modal-progress').removeClass('active');
        return modal;
    };
    modal.hideBtnBar = function () {
        modal.find('.modal-footer').hide();
    };
    modal.on('focus', 'input[type="text"],input:not([type])', function () {
        this.select();
    });
    modal.title = function (title) {
        modal.find('.modal-title').html(title);
        return modal;
    };
    modal.content = function (content) {
        modal.find('.modal-body').html(content);
        return modal;
    };
    modal.footer = function (footer) {
        modal.find('.modal-footer').html(footer);
        return modal;
    };
    modal.hide = function () {
        modal.modal('hide');
        return modal;
    };
    modal.show = function () {
        modal.modal();
        return modal;
    };
    modal.showStatic = function (callback) {
        if (callback) {
            modal.one('shown.bs.modal', callback);
        }
        modal.modal({'backdrop': 'static'});
        return modal;
    };
    return modal;
}

function popover() {

}

function btnWaiting(btn) {
    if (btn.find('>i.fa-spin').length === 0) {
        btn.prepend('<i class="fa fa-circle-o-notch fa-spin fa-fw margin-bottom"></i>');
    }
    btn.addClass('waiting');
}

function isBtnWaiting(btn) {
    return btn.is('.waiting');
}

function btnFinished(btn) {
    btn.removeClass('waiting');
}

function richButton(btn) {
    btn.wait = () => {
        if (btn.find('>i.fa-spin').length === 0) {
            btn.prepend('<i class="fa fa-circle-o-notch fa-spin fa-fw margin-bottom"></i>');
        }
        btn.addClass('waiting');
        return btn;
    };
    btn.finish = () => {
        btn.removeClass('waiting');
        return btn;
    };
    btn.isWaiting = () => btn.is('.waiting');
    btn.click = (handler) => {
        btn.on('click', function () {
            if (btn.isWaiting()) {
                return;
            }
            handler();
        });
        return btn;
    };
    return btn;
}

function bindPicker(selector) {
    selector.each(function () {
        _doBindPicker($(this));
    });
}

/**
 * 绑定选择弹窗组件事件
 * <p>配置项：</p>
 * <ul>
 *     <li>data-api:获取数据的地址</li>
 *     <li>data-max:最大可选择项，默认1</li>
 *     <li>data-search:值为1时显示搜索框，默认不显示</li>
 *     <li>data-value-property:数据项的value属性名称，默认'id'</li>
 *     <li>data-text-property:数据项的text属性名称，默认'name'</li>
 * </ul>
 * @param element 要绑定的元素
 * TODO: 弹窗时应用表单当前值
 */
function _doBindPicker(element) {
    const uiEl = $(`
<div class="input-group">
    <div class="form-control form-control-static"></div>
    <a class="input-group-addon btn btn-default" title="点击进行选择"><span class="fa fa-th"></span></a>
</div>
`).insertAfter(element);
    const max = parseInt(element.attr('data-max') || '1');
    const api = element.attr('data-api');
    const search = element.attr('data-search') === '1';
    const valueProperty = element.attr('data-value-property') || 'id';
    const textProperty = element.attr('data-text-property') || 'name';
    const displayEl = uiEl.find('div');
    if (element.attr('tabindex') != null) {
        uiEl.attr('tabindex', element.attr('tabindex'));
        element.removeAttr('tabindex');
    }
    let itemContainer;
    let searchBar = null;
    element.attr('type', 'hidden');
    const modal = createEmptyModal('选择', function () {
        const result = [];
        const resultTexts = [];
        displayEl.empty();

        itemContainer.find('.checked').each(function () {
            result.push($(this).attr('data-id'));
            resultTexts.push($(this).text());
        });
        element.val(result.join(','));
        displayEl.text(resultTexts.join('、'));
        if (searchBar !== null) {
            searchBar.find('input').val('');
        }
        console.log(result, resultTexts);
        modal.hide();
    });
    modal.attr('data-no-form', '1').addClass('ui-picker');
    const modalBody = modal.find('.modal-body');
    if (search) {
        searchBar = $('<div class="ui-picker-search-bar"><div class="input-group"><span class="input-group-addon">请输入搜索关键词</span><input class="form-control"></div></div>').appendTo(modalBody);
        let searchText = '';
        searchBar.find('input').on('keyup', function () {
            const text = $(this).val();
            if (text !== searchText) {
                searchText = text;
                loadData(text);
            }
        });
    }
    const previewEl = $('<div class="ui-picker-preview"></div>').appendTo(modalBody);
    itemContainer = $('<ul class="ui-picker-item-container"></ul>').appendTo(modalBody);
    // 绑定点击选项事件
    itemContainer.on('click', 'a', function () {
        if ($(this).is('.checked')) {
            $(this).removeClass('checked');
        } else {
            if (max === 1) {
                // 当只能选择一项的时候，将忆选项置为未选中
                $(this).addClass('checked').siblings('.checked').removeClass('checked');
            } else {
                if (itemContainer.find('.checked').length >= max) {
                    // 超过了最大选项数
                    return;
                }
                $(this).addClass('checked');
            }
        }
        const texts = [];
        itemContainer.find('.checked').each(function () {
            texts.push($(this).text());
        });
        previewEl.empty().append(texts.join('、'));
    });

    /**
     * 加载数据
     * @param searchText 过滤关键这
     */
    function loadData(searchText) {
        $.ajax({
            url: api.replace('{search}', searchText),
            success: (result) => {
                if (result.status === 200) {
                    renderItems(result.data);
                } else {
                    Alert.error(result.error);
                }
            }
        })
    }

    /**
     * 渲染数据
     * @param data 数据
     */
    function renderItems(data) {
        itemContainer.empty();
        if (data.length === 0) {
            itemContainer.append('<div class="ui-picker-empty">没有找到相关数据.</div>');
            return;
        }
        data.forEach(item => {
            itemContainer.append(`<li><a data-id="${item[valueProperty]}" title="${item[textProperty]}">${item[textProperty]}</a></li>`);
        });
    }

    uiEl.on('click focus', function () {
        modal.showStatic();
        loadData('');
    });
}


/**
 * 清除表单中的验证错误提示
 * @param form 表单
 */
function clearFormErrors(form) {
    form.find('.form-group>.error').remove();
}

/**
 * 显示表单验证错误提示
 * @param form 表单
 * @param errors 错误信息{fieldName : [error...]}
 */
function applyFormErrors(form, errors) {
    for (const name in  errors) {
        if (!errors.hasOwnProperty(name)) {
            continue;
        }
        let input = form.find(`[name="${name}"]`);
        if (input.length === 0) {
            input = form.find(`[data-form-for="${name}"]`);
        }
        input.closest('.form-group').append($('<p class="error"></p>').text(errors[name][0]));
    }
}

function applyFormError(input, error) {
    input.closest('.form-group').append($('<p class="error"></p>').text(error));
}

/**
 * 上传文件
 * @param fileInput file类型的input表单元素
 * @param callback 回调方法
 * @param options 选项, bucket: 直接上传资源到bucket而不是tmp
 */
function upload(fileInput, callback, options = {}) {
    let url = base + '/upload/prepare';
    if (options.bucket) {
        const suffix = getFileExtension(fileInput.val());
        url += '?bucket=' + options.bucket + '&suffix=' + suffix;
    }
    new Promise((resolve, reject) => {
        $.get(url, function (result) {
            if (result.status === 200) {
                resolve(result.data);
            } else {
                reject();
            }
        });
    }).then((data) => {
        const file = fileInput[0].files[0];
        const formData = new FormData();
        formData.append("file", file);
        formData.append("token", data.token);
        if (data.key) {
            formData.append("key", data.key);
        }
        const xhr = new XMLHttpRequest();
        xhr.addEventListener("load", function (event) {
            const result = JSON.parse(event.target.responseText);
            if (result.status === 200) {
                callback(result.data);
            } else {
                Alert.error(result.error);
            }
        }, false);
        xhr.open("POST", upload_server + '/upload');
        xhr.send(formData);
    });
}

/**
 * 获取文件名后缀
 * @param filename 文件名
 * @param includeDot 结果是否包含点
 * @returns {string} 后缀
 */
function getFileExtension(filename, includeDot = true) {
    const slashIndex = filename.lastIndexOf('/');
    const index = slashIndex === -1 ? filename.lastIndexOf('.') : filename.lastIndexOf('.', slashIndex);
    if (index !== -1) {
        return filename.substring(includeDot ? index : index + 1);
    }
    return '';
}

/**
 * 往url追加参数
 * @param url 原始URL
 * @param paramName 参数名称(当paramValue为undefined时, paramName视为已url-encode的参数对列表, 如param1=value1&param2=value2...)
 * @param paramValue 参数值
 * @returns {string} 追加参数后的URL
 */
function appendQueryParameter(url, paramName, paramValue) {
    let uri = url;
    let hash = '';
    const hashPos = url.indexOf('#');
    if (hashPos !== -1) {
        uri = url.substring(0, hashPos);
        hash = url.substring(hashPos);
    }
    let result = uri;
    if (uri.indexOf('?') === -1) {
        result += '?';
    } else {
        if (!uri.endsWith('&')) {
            result += '&';
        }
    }
    if (paramValue === undefined) {
        return result + paramName;
    }
    return result + paramName + '=' + encodeURIComponent(paramValue) + hash;
}

/**
 * 下载文件
 * @param url 下载地址
 */
function downloadFile(url) {
    let downloadFrame = $('#downloadFrame');
    if (downloadFrame.length === 0) {
        downloadFrame = $('<iframe id="downloadFrame" style="width:0;height:0;opacity:0;visibility:hidden;"></iframe>').appendTo('body');
    }
    downloadFrame.attr('src', url);
}

/**
 * 下载表格数据
 * @param url 下载地址
 * @param searchForm 搜索表单
 * @param dataTable 表格
 */
function downloadTable(url, searchForm, dataTable) {
    downloadFile(url + '?_export=true&_rand=' + new Date().getMilliseconds() + '&' + searchForm.serialize() + '&orderBy=' + readOrderBy(dataTable));
}

/**
 * 去重
 * @param raw 原始数组
 */
function filterDuplicate(raw) {
    return raw.filter((element, index, self) => self.lastIndexOf(element) === index);
}


/**
 * 格式化ID列表，以英文逗号隔开的数字列表
 * @param raw 原始字符串
 * @param distinct 去重
 */
function formatIds(raw, distinct = true) {
    const result = [];
    let c;
    for (let i = 0; i < raw.length; i++) {
        c = raw[i];
        if (c >= '0' && c <= '9') {
            result.push(c);
            continue;
        }
        if (result.length === 0 || result[result.length - 1] === ',') {
            continue;
        }
        result.push(',');
    }
    if (result.length > 0 && result[result.length - 1] === ',') {
        result.pop();
    }
    const r = result.join('');
    if (!distinct || r.length === 0) {
        return r;
    }
    const array = r.split(',');
    return filterDuplicate(array).join(',');
}

/**
 * 格式化词语，逗号、换行与空格视为分隔符，其他视为合法字符
 * @param raw 原始字符串
 * @returns {string} 以英文逗号隔开的词语列表
 */
function formatWords(raw) {
    const result = [];
    let c;
    for (let i = 0; i < raw.length; i++) {
        c = raw[i];
        if (c !== '\r' && c !== '\n' && c !== ',' && c !== '，' && c !== ' ') {
            result.push(c);
            continue;
        }
        if (result.length === 0 || result[result.length - 1] === ',') {
            continue;
        }
        result.push(',');
    }
    if (result.length > 0 && result[result.length - 1] === ',') {
        result.pop();
    }
    return result.join('');
}

function formatDefaultDate(date) {
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate();
    return year + '-' + (month < 10 ? ('0' + month) : month) + '-' + (day < 10 ? ('0' + day) : day);
}

function formatDefaultDateTime(date) {
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate();
    const hour = date.getHours();
    const minute = date.getMinutes();
    const second = date.getSeconds();
    return year + '-' + (month < 10 ? ('0' + month) : month) + '-' + (day < 10 ? ('0' + day) : day) + ' ' + hour + ':' + minute + ':' + second;
}

/**
 * 格式化文档，去除每行首尾空格，去除空行
 * @param raw 原始文档
 * @returns {string} 格式化后的文档
 */
function normalizeDoc(raw) {
    return raw.split('\n').map((row, index) => row.trim()).filter(row => row.length > 0).join('\n');
}

function highlight(raw, highlights, wrapperLeft = '<code class="highlight">', wrapperRight = '</code>') {
    let result = raw;
    for (let i = 0; i < highlights.length; i++) {
        result = result.replace(new RegExp(highlights[i], 'g'), wrapperLeft + highlights[i] + wrapperRight);
    }
    return result;
}

function highlightByGroup(text, highlights, handleLetter = true) {
    text = text.replace(/[|\\/^~`+=_-]/g, '');
    const starts = [];
    const ends = [];
    const matches = {};
    for (let i = 0; i < text.length; i++) {
        starts.push([]);
        ends.push(0);
    }
    for (let o in highlights) {
        if (!highlights.hasOwnProperty(o)) {
            continue;
        }
        highlights[o].forEach((highlight) => {
            let pos = 0;
            let step = highlight.length;
            while ((pos = text.indexOf(highlight, pos)) !== -1) {
                if (matches[o] === undefined) {
                    matches[o] = 0;
                }
                matches[o] += 1;
                starts[pos].push(o);
                ends[pos + step - 1]++;
                pos += step;
            }
        });

    }
    const result = [];
    let letterStarted = false;
    for (let i = 0; i < text.length; i++) {
        const c = text.charAt(i);
        const isLetter = ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
        if (!isLetter && letterStarted) {
            letterStarted = false;
            result.push('</code>');
        }
        if (starts[i].length > 0) {
            starts[i].forEach((group) => result.push(`<code class="highlight highlight-${group}">`));
        }
        if (handleLetter && isLetter && !letterStarted) {
            letterStarted = true;
            result.push(`<code class="highlight highlight-letter">`);
        }
        result.push(text.charAt(i));
        if (ends[i] > 0) {
            for (let j = 0; j < ends[i]; j++) {
                result.push('</code>');
            }
        }
    }
    if (letterStarted) {
        result.push('</code>');
    }
    let html = result.join('');
    return {html: '<p>' + html.replace(/\n/g, '</p><p>') + '</p>', matches};
}

function highlightByRemark(text, remarks, lineSeparator) {
    let paras = text.split(lineSeparator);
    for (let i = 0; i < remarks.length; i++) {
        let line = remarks[i].line;
        let word = remarks[i].word;
        paras[line - 1] = paras[line - 1].replace(new RegExp(word, "gm"), "<code class='highlight'>" + word + "</code>");
    }
    text = paras.join("\n");
    return text;
}


//输入框边框闪烁
function twinkle(ele, cls, times) {
    var i = 0, t = false, o = ele.attr("class") + " ", c = "", times = times || 2;
    if (t) return;
    t = setInterval(function () {
        i++;
        c = i % 2 ? o + cls : o;
        ele.attr("class", c);
        if (i === 2 * times) {
            clearInterval(t);
            ele.removeClass(cls);
        }
    }, 200);
};

function bindCronSelector(input) {
    return input.jqCron({
        default_value: '0 0 12 * *',
        numeric_zero_pad: true,
        multiple_dom: true,
        multiple_month: true,
        multiple_mins: true,
        multiple_dow: true,
        multiple_time_hours: true,
        multiple_time_minutes: true,
        lang: 'cn'
    });
}

function unbindCronSelector(input) {
    input.siblings('.jqCron').remove();
    input.unbind('blur');
}

//Loads the correct sidebar on window load,
//collapses the sidebar on window resize.
// Sets the min-height of #page-wrapper to window size
$(function () {
    $.ajaxPrefilter(function (options, originalOptions, jqXHR) {
        options.error = function (request, textStatus, errorThrown) {
            if (request.status === 401) {
                window.location.href = request.getResponseHeader('x-login-url');
                return;
            }
        };
        // if(originalOptions.success !== undefined) {
        //     options.success = function(data, textStatus, jqXHR){
        //         console.debug(data.status);
        //         if(data.status === 401) {
        //             window.location = data.data.loginUrl;
        //             return;
        //         }
        //         originalOptions.success(data, textStatus, jqXHR);
        //     };
        // }
    });
    $('[data-toggle="tooltip"]').tooltip();
    // $.alert = (function () {
    //     const toastOffset = 8;
    //     const toastLife = 2000;
    //     function clearToast(toast) {
    //         toast.removeClass('in');
    //         setTimeout(() => {
    //             var height = toast.outerHeight();
    //             toast.nextAll().each(function () {
    //                 $(this).css('top', $(this).position().top - height - toastOffset);
    //             });
    //             toast.remove();
    //         }, 150);
    //     }
    //
    //     return function (msg) {
    //         if(msg === null || msg.length === 0) {
    //             return;
    //         }
    //         const toast = $('<div class="toast fade"><span class="close">&times;</span><p></p></div>');
    //         toast.find('p').text(msg);
    //         let interval = null;
    //         toast.on('click', '.close', function () {
    //             if (!toast.is('.in')) {
    //                 return;
    //             }
    //             window.clearTimeout(interval);
    //             clearToast(toast);
    //         });
    //         let lastToast = $('.toast:last');
    //         if (lastToast.length > 0) {
    //             toast.css('top', lastToast.position().top + lastToast.outerHeight() + toastOffset);
    //         }
    //         toast.appendTo('body');
    //         setTimeout(() => {
    //             toast.addClass('in');
    //             interval = window.setTimeout(() => clearToast(toast), toastLife);
    //         }, 10);
    //     };
    // }());

    // 绑定导航栏随容器大小显示/隐藏的事件
    $(window).bind("load resize", function () {
        var topOffset = 50;
        var width = (this.window.innerWidth > 0) ? this.window.innerWidth : this.screen.width;
        if (width < 768) {
            $('div.navbar-collapse').addClass('collapse');
            topOffset = 100; // 2-row-menu
        } else {
            $('div.navbar-collapse').removeClass('collapse');
        }

        var height = ((this.window.innerHeight > 0) ? this.window.innerHeight : this.screen.height) - 1;
        height = height - topOffset;
        if (height < 1) height = 1;
        if (height > topOffset) {
            $("#page-wrapper").css("min-height", (height) + "px");
        }
    });
    // 侧边栏菜单初始化及响应点击事件
    const sideMenu = $('#side-menu');
    sideMenu.find('a.active').parents('li').addClass('active').find('>ul.collapse').addClass('in');
    sideMenu.find('a:not([href])').click(function () {
        $(this).closest('li').toggleClass('active').find('>ul').toggleClass('in');
    });

    (function () {
        $('th[data-sortable="true"]').click(function () {
            const order = $(this).attr('data-order');
            if (order === 'asc') {
                $(this).attr('data-order', 'desc');
            } else if (order === 'desc') {
                $(this).attr('data-order', '');
            } else {
                $(this).attr('data-order', 'asc');
            }
        });
    }());

    // 修改密码
    (function () {
        let panel = null;
        let form = null;
        $('#changePasswordBtn').click(function () {
            if (panel === null) {
                panel = createEmptyModal("修改密码", () => {
                    const password = panel.find('[name="password"]').val();
                    const confirmPassword = panel.find('[name="confirmPassword"]').val();
                    if (password.length < 6 || password.length > 20) {
                        applyFormErrors(form, {'password': ['长度必须介于6与20之间']});
                        return;
                    }
                    if (password !== confirmPassword) {
                        applyFormErrors(form, {'confirmPassword': ['两次输入密码不一致']});
                        return;
                    }
                    clearFormErrors(form);
                    panel.showProgress();
                    $.ajax({
                        url: `${base}/personal/change_passwd`,
                        data: form.serialize(),
                        type: 'post',
                        success: function (result) {
                            if (result.status === 200) {
                                Alert.success('操作成功!');
                                panel.modal('hide');
                            } else {
                                Alert.error(result.error);
                            }
                        },
                        complete: () => panel.hideProgress()
                    });
                });
                panel.find('.modal-body').append(`
<div class="row">
    <div class="col-lg-12">
        <form role="form">
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_oldPassword" class="form-required">当前密码</label>
                    <input id="add_modal_oldPassword" name="oldPassword" type="password" class="form-control" placeholder="当前密码">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_password" class="form-required">新密码</label>
                    <input id="add_modal_password" name="password" type="password" class="form-control" placeholder="新密码">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-12">
                    <label for="add_modal_confirmPassword" class="form-required">确认密码</label>
                    <input id="add_modal_confirmPassword" name="confirmPassword" type="password" class="form-control" placeholder="确认密码">
                </div>
            </div>
        </form>
    </div>
</div>
`
                );
                form = panel.find('form');
            }
            clearFormErrors(form);
            form[0].reset();
            panel.modal({backdrop: 'static'});
        });
    })();

    // 修改个人资料
    (function () {
        let panel = null;
        $('#editProfileBtn').click(function () {
            if (panel === null) {
                panel = createEmptyModal('修改资料', () => {
                    clearFormErrors(panel.find('form'));
                    panel.showProgress();
                    $.ajax({
                        url: `${base}/personal/profile`,
                        type: 'post',
                        data: panel.find('form').serialize(),
                        success: function (result) {
                            if (result.status === 200) {
                                Alert.success('操作成功!');
                                panel.modal('hide');
                            } else {
                                if (result.data !== null) {
                                    applyFormErrors(panel.find('form'), result.data);
                                    Alert.error("操作失败!");
                                } else {
                                    Alert.error(result.error);
                                }
                            }
                        },
                        complete: () => panel.hideProgress()
                    });
                });
            }
            renderModalLoadBar(panel);
            panel.modal({backdrop: 'static'});
            $.ajax({
                url: `${base}/personal/profile`,
                dataType: 'html',
                type: 'get',
                success: function (result) {
                    panel.find('.modal-body').html(result);
                }
            })
        });
        return panel;
    })();

    // 修改小编资料
    (function () {
        let panel = null;
        $('#editEditorBtn').click(function () {
            if (panel === null) {
                panel = createEmptyModal('修改小编资料', () => {
                    clearFormErrors(panel.find('form'));
                    panel.showProgress();
                    $.ajax({
                        url: `${base}/personal/editor_info`,
                        type: 'post',
                        data: panel.find('form').serialize(),
                        success: function (result) {
                            if (result.status === 200) {
                                Alert.success('操作成功!');
                                panel.modal('hide');
                            } else {
                                if (result.data !== null) {
                                    applyFormErrors(panel.find('form'), result.data);
                                    Alert.error("操作失败!");
                                } else {
                                    Alert.error(result.error);
                                }
                            }
                        },
                        complete: () => panel.hideProgress()
                    });
                });
            }
            renderModalLoadBar(panel);
            panel.modal({backdrop: 'static'});
            $.ajax({
                url: `${base}/personal/editor_info`,
                dataType: 'html',
                type: 'get',
                success: function (result) {
                    panel.find('.modal-body').html(result);
                }
            })
        });
        return panel;
    })();
    // var url = window.location;
    // // var element = $('ul.nav a').filter(function() {
    // //     return this.href == url;
    // // }).addClass('active').parent().parent().addClass('in').parent();
    // var element = $('ul.nav a').filter(function() {
    //     return this.href == url;
    // }).addClass('active').parent();
    //
    // while (true) {
    //     if (element.is('li')) {
    //         element = element.parent().addClass('in').parent();
    //     } else {
    //         break;
    //     }
    // }
});
