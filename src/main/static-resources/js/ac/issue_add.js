(function () {
    const baseUrl = base + '/ac/comic/' + comic_id + '/issue';

    function addPageIndexPrefix(name, index) {
        if (name.indexOf('.') === -1) {
            return `pages[${index}].${name}`;
        }
        return `pages[${index}].${name.substring(name.indexOf('.') + 1)}`;
    }

    $(function () {
        const form = $('#page-wrapper').find('form');
        form.submit(function (e) {
            e.preventDefault();
            clearFormErrors(form);
            startPageProgress();
            const liList = form.find('#comic-page-container li:not([data-role])');
            if (liList.length === 0) {
                Alert.error("每话至少需要一张图片！");
                return;
            }
            liList.each(function (index, item) {
                $(item).find('input[name]').each(function () {
                    $(this).attr('name', addPageIndexPrefix($(this).attr('name'), index));
                });
            });
            $.ajax({
                url: form.attr('action'),
                type: form.attr('method'),
                data: form.serialize(),
                success: function (result) {
                    if (result.status === 200) {
                        Alert.success('操作成功!');
                        window.location = baseUrl;
                    } else {
                        if (result.data !== null) {
                            applyFormErrors(form, result.data);
                            Alert.error("操作失败!");
                        } else {
                            Alert.error(result.error);
                        }
                    }
                },
                complete: () => finishPageProgress()
            });
        });
        form.find('[name="publicationTime"]').datetimepicker({
            format: "YYYY-MM-DD HH:mm",
            locale: 'zh-cn'
        });
        window.imageUploadCallback = function (data) {
            const url = data.domain + data.key;
            form.find('[name="image"]').val(url).siblings('.upload-preview').find('img').remove().end().prepend(`<img src="${url}">`);
        };
        window.pageUploadCallback = function (data) {
            const elId = `page_${data.key}`;
            const record = $(`
<li id="${elId}">
    <img src="${data.url}">
    <div class="toolbar">
        <input type="hidden" name="image" value="${data.key}">
        <input type="hidden" name="width" value="${data.width}">
        <input type="hidden" name="height" value="${data.height}">
        <input type="hidden" name="size" value="${data.size}">
        <input type="hidden" name="previewColor" value="${data.color}">
        <span><label>尺寸：</label><code>${data.width}x${data.height}</code><label>大小：</label><code>${formatBytes(data.size)}</code><label>预览色：</label><span title="#${data.color}" style="background-color:${'#' + data.color};" class="preview-color">&nbsp;</span></span>
        <button data-role="move-up" type="button" class="btn btn-primary">上移</button>
        <button data-role="move-down" type="button" class="btn btn-primary">下移</button>
        <button data-role="remove" data-token="${data.manageToken}" type="button" class="btn btn-danger">删除</button>
    </div>
</li>
`);
            form.find('#comic-page-toolbar').before(record);
            form.find('#comic-page-menu').append(`<a href="#${elId}"></a>`);
        };
        form.on('click', '.btn[data-role=move-up]', function () {
            const li = $(this).closest('li');
            if (li.prev().length > 0) {
                li.after(li.prev());
            }
        }).on('click', '.btn[data-role=move-down]', function () {
            const li = $(this).closest('li');
            if (li.next(':not([data-role="tool"])').length > 0) {
                li.before(li.next());
            }
        }).on('click', '.btn[data-role=remove]', function () {
            const li = $(this).closest('li');
            const deleteToken = $(this).attr('data-token');
            const key = li.find('[name="image"]').val();
            Confirm.show(`确定要删除吗？删除后图片不可恢复！`, () => {
                $.ajax({
                    url: base + '/upload/qiniu?type=comic_page&token=' + deleteToken + '&key=' + key,
                    type: 'DELETE'
                });
                li.remove();
            });
        });
        const pageMenu = $('#comic-page-menu');
        const pageContainer = $('#comic-page-container');
        $(window).scroll(function () {
            const offset = pageContainer.offset();
            if (window.scrollY > offset.top) {
                pageMenu.addClass('scrolling');
            } else {
                pageMenu.removeClass('scrolling');
            }
        })
            .trigger('scroll');
        // .resize(function () {
        //     $('#comic-page-toolbar').css('left', pageContainer.offset().left + pageContainer.width() - 150);
        // }).trigger('resize');
    });
}());