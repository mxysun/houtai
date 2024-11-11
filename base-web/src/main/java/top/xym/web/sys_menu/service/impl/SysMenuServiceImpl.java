package top.xym.web.sys_menu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.xym.web.sys_menu.entity.MakeMenuTree;
import top.xym.web.sys_menu.entity.SysMenu;
import top.xym.web.sys_menu.mapper.SysMenuMapper;
import top.xym.web.sys_menu.service.SysMenuService;

import java.util.Arrays;
import java.util.List;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    @Override
    public List<SysMenu> getParent() {
//        定义了一个字符串数组，表示两种可能的菜单类型。
        String[] type = {"0", "1"};
//        将数组转换为一个列表，方便后续使用
        List<String> strings = Arrays.asList(type);
//        创建查询包装器
        QueryWrapper<SysMenu> query = new QueryWrapper<>();
//        设置查询条件
        query.lambda().in(SysMenu::getType, strings).orderByAsc(SysMenu::getOrderNum);
//        执行查询
        List<SysMenu> menuList = this.baseMapper.selectList(query);
        //组装顶级树  添加顶级菜单  创建一个新的SysMenu对象表示顶级菜单。设置了顶级菜单的各种属性，如标题、标签、父菜单 ID 和菜单 ID 等
        SysMenu menu = new SysMenu();
        menu.setTitle("顶级菜单");
        menu.setLabel("顶级菜单");
        menu.setParentId(-1L);
        menu.setMenuId(0L);
        menu.setValue(0L);
        menuList.add(menu);
        //组装菜单树
        return MakeMenuTree.makeTree(menuList, -1L);
    }
}